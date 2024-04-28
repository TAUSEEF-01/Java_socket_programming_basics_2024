import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for client...");
            ServerSocket sc = new ServerSocket(9000);
            Socket sca = sc.accept();
            System.out.println("Connection established!!!");

            BufferedReader in = new BufferedReader(new InputStreamReader(sca.getInputStream()));
            String str = in.readLine();
            PrintWriter out = new PrintWriter(sca.getOutputStream(), true);
            out.println("Server says: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

