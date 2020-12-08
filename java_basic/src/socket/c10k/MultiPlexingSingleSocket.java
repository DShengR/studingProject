package socket.c10k;


import java.io.IOException;
        import java.net.InetSocketAddress;
        import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
        import java.util.Set;

public class MultiPlexingSingleSocket {
    Selector selector;

    public static void main(String[] args) throws IOException {
        MultiPlexingSingleSocket multiPlexingSingleSocket=new MultiPlexingSingleSocket();
        multiPlexingSingleSocket.start();
    }
    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        //相当于epoll的epoll_create
        selector=Selector.open();
        //相当于epoll的epoll_ctl
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public void start() throws IOException {
        init();
        while(true){
            System.out.println("12345");
            int select = selector.select();
            if(select >0){
                System.out.println("67890");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        acceptSocket(key);

                    }else if(key.isReadable()){
                        readData(key);
                    }else if(key.isWritable()){
                        writeHandle(key);
                    }
                }
            }
        }
    }
    public void acceptSocket(SelectionKey key) throws IOException {
        SocketChannel accept = ((ServerSocketChannel)key.channel()).accept();
        System.out.println(accept.socket().getPort()+"---connected");
        accept.configureBlocking(false);
        ByteBuffer buffer=ByteBuffer.allocate(8096);
        accept.register(selector,SelectionKey.OP_READ,buffer);
    }
    public void readData(SelectionKey key) throws IOException {
        SocketChannel socket=(SocketChannel) key.channel();
        ByteBuffer buffer= (ByteBuffer) key.attachment();
        while (true){
            int read=socket.read(buffer);
            if(read>0){
                byte[] data=new byte[buffer.position()];
                buffer.flip();
                buffer.get(data);
                buffer.clear();
                System.out.println(socket.socket().getPort()+"--say:"+new String(data));
                socket.register(selector,SelectionKey.OP_WRITE);
            }else if(read ==0 ){
                break;
            }else{
                socket.close();
                break;
            }
        }
    }
    public void writeHandle(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer attachment = (ByteBuffer) key.attachment();
        attachment.put("received".getBytes());
        channel.write(attachment);
        key.cancel();
    }
}
