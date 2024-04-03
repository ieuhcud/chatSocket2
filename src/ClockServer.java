import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClockServer {

    public static void main(String[] args) {
        int port = 9999; // Port mặc định

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server đang chờ kết nối...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Đã kết nối từ: " + socket.getInetAddress().getHostAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    String receivedTime = in.readLine();
                    if (receivedTime == null) {
                        System.out.println("Không nhận được dữ liệu từ client.");
                        break;
                    }
                    System.out.println("Thời gian nhận từ client: " + receivedTime);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
