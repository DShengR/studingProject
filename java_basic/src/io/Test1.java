package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test1 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream=new FileInputStream(new File(""));
        byte[] b=new byte[1024];
        InputStream inputStream1=new ByteArrayInputStream(b);
        InputStream inputStream3=new ObjectInputStream(inputStream);

        InputStreamReader reader=new InputStreamReader(inputStream);
        reader.read();
        Writer writer=new OutputStreamWriter(new FileOutputStream(new File("")));

        writer.write(1);
        BufferedWriter bufferedWriter=new BufferedWriter(writer);
        bufferedWriter.write(1);

        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File((""))));
        bufferedOutputStream.write(1);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        RandomAccessFile raf=new RandomAccessFile(new File("/root/test/out.txt"),"rw");
        raf.write("dsrdsr".getBytes());
        raf.seek(4);
        FileChannel channel = raf.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE,0,1024);
        map.put("aaaa".getBytes());
    }
}
