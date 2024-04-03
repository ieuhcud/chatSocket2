import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockClient {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Địa chỉ IP hoặc tên máy chủ
        int port = 9999; // Port mặc định

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Đã kết nối đến máy chủ.");

            while (true) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                out.println(time); // Gửi thời gian từ client đến server
                Thread.sleep(1000); // Chờ 1 giây trước khi gửi thời gian tiếp theo
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
