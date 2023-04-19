import java.net.*;
import java.io.*;
public class UDPClient{
    public static void main(String args[])throws Exception{
        byte b[] = new byte[1024];
        System.out.println("Connecting UDP Server....!");
        FileInputStream fin = new FileInputStream("UDPSend.txt");
        DatagramSocket dsoc = new DatagramSocket();
        int i = 0;
        while(fin.available() != 0){
            b[i] = (byte)fin.read();
            i++;
        }
        fin.close();
        dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),1000));
    }
}