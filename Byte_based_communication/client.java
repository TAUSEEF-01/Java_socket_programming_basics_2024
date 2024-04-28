package Byte_based_communication;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Server address and port
        System.out.println("Connected to server.");

        InputStream in = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteMessage = buffer.toByteArray();
        String textMessage = new String(byteMessage, "UTF-8");
        System.out.println("Received message from server: " + textMessage);

        in.close();
        socket.close();
    }
}


//package Byte_based_communication;
//
//import java.io.*;
//import java.net.*;
//import java.util.Objects;
//
//public class client {
//    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost", 12345); // Server address and port
//        System.out.println("Connected to server.");
//
//
//        while (true) {
////        for (int i = 0; i < 5; i++) {
//
//            InputStream in = socket.getInputStream();
//            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//            int nRead;
//            byte[] data = new byte[1024];
//            while ((nRead = in.read(data, 0, data.length)) != -1) {
//                buffer.write(data, 0, nRead);
//            }
//
//            buffer.flush();
//            byte[] byteMessage = buffer.toByteArray();
//            String textMessage = new String(byteMessage, "UTF-8");
//
//
//            if (Objects.equals(textMessage, "exit")) {
//                in.close();
//                break;
//            }
//            else {
//                System.out.println("Server: " + textMessage);
//            }
//        }
//
//        socket.close();
//    }
//}