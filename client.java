import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Client stated...");
            Socket sc = new Socket("localhost", 9000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
