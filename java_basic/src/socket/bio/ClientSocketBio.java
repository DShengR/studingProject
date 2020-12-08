package socket.bio;

import java.io.*;
import java.net.Socket;

public class ClientSocketBio {
    public void socket(){
        try {
            Socket socket=new Socket("127.0.0.1",9090);
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            OutputStream out=socket.getOutputStream();

            BufferedReader terReader=new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String msg = terReader.readLine();

                if(msg != null){
                    System.out.println("中断："+msg);
                    out.write(msg.getBytes());
                    //writer.write(msg);
                    //writer.flush();
                    System.out.println("发送");
                   String backMsg = reader.readLine();
                   System.out.println(backMsg);
                }
            }
            //socket.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    public static void main(String[] args) {
        ClientSocketBio test=new ClientSocketBio();
        test.socket();
    }*/

    public static void main(String[] args) {

        try {
            Socket client = new Socket("127.0.0.1",9090);

            client.setSendBufferSize(20);
            client.setTcpNoDelay(true);
            OutputStream out = client.getOutputStream();

            InputStream in = System.in;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while(true){
                String line = reader.readLine();
                if(line != null ){
                    byte[] bb = line.getBytes();
                    for (byte b : bb) {
                        out.write(b);
                        out.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
