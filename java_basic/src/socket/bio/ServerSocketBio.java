package socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class ServerSocketBio {
    public void serverSocket(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket accept = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                            System.out.println("aaaaa:" + accept);
                            String msg = reader.readLine();
                            System.out.println(msg);
                            writer.write("I am server");
                            writer.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            } catch(IOException e){
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        ServerSocketBio test=new ServerSocketBio();
        test.serverSocket();
    }
}
