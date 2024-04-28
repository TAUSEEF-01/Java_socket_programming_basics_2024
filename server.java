import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for client...");
            ServerSocket sc = new ServerSocket(9000);
            Socket sca = sc.accept();
            System.out.println("Connection established!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
