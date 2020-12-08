package io;

import java.nio.ByteBuffer;

public class TestByteBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        byte b = buffer.get();
        System.out.println(b);
        buffer.flip();
        byte b1 = buffer.get();
        System.out.println(b1);
        buffer.put((byte) 4);


    }
}
