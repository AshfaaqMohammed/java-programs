package com.Networking;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<ByteBuffer> printBuffer = (buffer)->{
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            System.out.printf("\"%s\" - ",new String(data, StandardCharsets.UTF_8));
        };

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        doOperation("print",buffer, (b)->System.out.print(b+"--- "));
        doOperation("write",buffer, (b)->b.put("ashfaaq".getBytes()));
        doOperation("Flip (from write to read): ",buffer,ByteBuffer::flip);
//        doOperation("Read",buffer,printBuffer);
//        doOperation("Flip (from read to write): ",buffer, ByteBuffer::flip);
////        doOperation("1. Chnage position", buffer,(b)->b.position(b.limit()));
////        doOperation("2. CHnage the limit ", buffer, (b)->b.limit(b.capacity()));
//        doOperation("Compact",buffer,ByteBuffer::compact);
//        doOperation("write",buffer, (b)->b.put("new ashfaaq".getBytes()));
////        doOperation("Flip (from write to read): ",buffer,ByteBuffer::flip);
//        doOperation("Slice",buffer.slice(0,buffer.position()),printBuffer);
//        doOperation("Append",buffer,(b)->b.put("****".getBytes()));
//        doOperation("Slice",buffer.slice(0,buffer.position()),printBuffer);

    }
    private static void doOperation(String op, ByteBuffer buffer, Consumer<ByteBuffer> c){
        System.out.printf("%-30s", op);
        c.accept(buffer);
        System.out.printf("Capacity = %d, Limit = %d, Position = %d, Remaining=%d%n",
                buffer.capacity(),
                buffer.limit(),
                buffer.position(),
                buffer.remaining());
    }
}
