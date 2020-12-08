package socket.c10k;

import socket.bio.ServerSocketBio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class BioSocket {
    public void serverSocket(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket accept = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("accept new client:" +accept.getPort());
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
