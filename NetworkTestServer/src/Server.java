import java.awt.*;
import java.awt.event.InputEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static boolean mRun = true;
    // ip address 정보 객체 생성
    static IpAddress ipAddress = new IpAddress();

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(ipAddress.getIpAddress(), 5000));
        System.out.println("Server Start!");

        while(mRun) {
            Socket socket = server.accept();
            System.out.println("Connected...");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // 받은 정보
            int received = dis.readInt();
            System.out.println("received: " + received);

            if(received == 0){
                mRun = false;
            }

            socket.close();
        }
        server.close();
        System.out.println("Terminated...");
    }
}
