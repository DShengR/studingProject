package socket.c10k;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) throws IOException {
        List<SocketChannel> clients=new ArrayList<>();
        SocketAddress address=new InetSocketAddress("192.168.220.111",8888);//
        ByteBuffer writeBuffer=ByteBuffer.allocate(1024);
        for(int i=10000;i<65534;i++){
            try {
                SocketChannel socketChannel=SocketChannel.open();
                SocketChannel socketChannel2=SocketChannel.open();
                socketChannel2.bind(new InetSocketAddress( 10001));//"192.168.220.1",
                socketChannel2.connect(address);

                writeBuffer.put(("hello , I am client ,wish have back!!!"+10001).getBytes());
                writeBuffer.flip();
                socketChannel2.write(writeBuffer);
                writeBuffer.clear();
                clients.add(socketChannel2);
                //System.out.println("write ok----");
               // socketChannel.bind(new InetSocketAddress("192.168.2.103", i));
            socketChannel.connect(address);
            clients.add(socketChannel);
            }catch (Exception e){
                System.out.println(e.getMessage()+"-----");
            }
        }
        System.out.println("clients size:"+clients.size());
        System.in.read();
    }
}
