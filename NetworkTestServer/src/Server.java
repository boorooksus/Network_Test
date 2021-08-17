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

            DataInputStream dis
                    = new DataInputStream(socket.getInputStream());

            // 데이터를 받음
            int received = dis.readInt();
            //int received2 = dis.readInt();

            System.out.println("received: " + received);
            //System.out.println("received2: " + received2);

            if(received == 0){
                mRun = false;
            }

            socket.close();
        }
        server.close();
        System.out.println("Terminated...");
    }
}
