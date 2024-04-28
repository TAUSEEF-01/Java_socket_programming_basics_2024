package Basic_text_send;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Client stated...");
            Socket sca = new Socket("localhost", 9000);
            System.out.println("Connection established!!! :))");

            int flag = 1;
            while (flag == 1) {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a string: ");
                String str = userInput.readLine();

                PrintWriter out = new PrintWriter(sca.getOutputStream(), true);
                out.println(str);

                BufferedReader in = new BufferedReader(new InputStreamReader(sca.getInputStream()));


                if (Objects.equals(str, "exit")) {
                    in.close();
                    flag = 0;
                    break;
                }

                System.out.println(in.readLine());
            }

            sca.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
