package Byte_based_communication;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        String textMessage = "Hello from server!";
        byte[] byteMessage = textMessage.getBytes("UTF-8"); // conversion in bytes to send the information

        OutputStream out = socket.getOutputStream();
        out.write(byteMessage);

        out.close();
        socket.close();
        serverSocket.close();
    }
}



//package Byte_based_communication;
//
//import java.io.*;
//import java.net.*;
//import java.util.Objects;
//
//public class server {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
//        System.out.println("Server started. Waiting for client...");
//
//        Socket socket = serverSocket.accept();
//        System.out.println("Client connected.");
//
//        while (true) {
//
//            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter a string: ");
//            String textMessage = userInput.readLine();
//
//            byte[] byteMessage = textMessage.getBytes("UTF-8"); // conversion in bytes to send the information
//
//            OutputStream out = socket.getOutputStream();
//            out.write(byteMessage);
//
//            out.close();
//
//            if (Objects.equals(textMessage, "exit")) {
//
//                break;
//            }
//        }
//
//        socket.close();
//        serverSocket.close();
//    }
//}