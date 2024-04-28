package String_based_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import static java.lang.System.out;

public class server {
    public static void main(String[] args) {
        try {
            out.println("Waiting for String_based_socket.client...");
            ServerSocket sc = new ServerSocket(9000);
            Socket sca = sc.accept();
            out.println("Connection established!!!");

            int flag = 1;
            while (flag == 1) {
                BufferedReader in = new BufferedReader(new InputStreamReader(sca.getInputStream()));
                String str = in.readLine();

                PrintWriter out = new PrintWriter(sca.getOutputStream(), true);

                if (Objects.equals(str, "exit")) {
                    flag = 0;
                    out.close();
                    break;
                }
                out.println("Server says: " + str);
            }

            sc.close();
            sca.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

