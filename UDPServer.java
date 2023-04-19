import java.net.*;
import java.io.*;
public class UDPServer {
    public static void main(String[] args)throws IOException {
        byte b[] = new byte[2048];
        System.out.println("UDP Server Running....!");
        DatagramSocket dsoc = new DatagramSocket(1000);
        FileOutputStream fout = new FileOutputStream("UDPRecieve.txt");
        DatagramPacket dp = new DatagramPacket(b,b.length);
        dsoc.receive(dp);
        String str = new String(dp.getData());
        fout.write(str.getBytes());
        System.out.println("File transfer completed....!");
        fout.close();
    }
}
