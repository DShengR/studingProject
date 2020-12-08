package socket.c10k;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class MultiPlexingMoreThreadsSocket {
    Selector selector;
    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);

        selector=Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public void start() throws IOException {
        while(true){
            int select = selector.select();
            if(select > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        key.cancel();
                        acceptHandle(key);
                    }else if(key.isReadable()){
                        readHandle(key);
                    }else if(key.isWritable()){
                        key.cancel();
                        writeHandle(key);

                    }
                }
            }
        }
    }
    public void acceptHandle(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocket = (ServerSocketChannel) key.channel();
        SocketChannel socket = serverSocket.accept();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        socket.configureBlocking(false);
        socket.register(selector,SelectionKey.OP_READ);
    }
    public void readHandle(SelectionKey key) throws IOException {
        new Thread(()->{
            SocketChannel socket = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            while(true){
                int read = 0;
                try {
                    read = socket.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(read>0){
                    byte[] data=new byte[buffer.position()];
                    buffer.flip();
                    buffer.get(data);
                    System.out.println(socket.socket().getPort()+"--say:"+new String(data));
                }else if(read ==0 ){
                    break;
                }else{
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }).start();

    }
    public void writeHandle(SelectionKey key) throws IOException {
        new Thread(()->{
            SocketChannel socket = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            try {
                socket.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
