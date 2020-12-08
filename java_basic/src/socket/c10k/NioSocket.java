package socket.c10k;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NioSocket {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        List<SocketChannel> channelList=new ArrayList<>();
        while(true){
            SocketChannel accept = serverSocketChannel.accept();
            if(accept !=null){
                channelList.add(accept);
                System.out.println("accept clinet:"+accept.socket().getPort());
            }
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            for(SocketChannel channel: channelList){
                int num = channel.read(buffer);
                if(num >0){
                    byte[] data=new byte[buffer.position()];
                    buffer.flip();
                    buffer.get(data);
                    System.out.println(channel+"say :"+new String(data));
                    buffer.clear();
                }
            }
        }
    }
}
