import java.net.*;
import java.io.*;
public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket=null;
        try{
            socket=new Socket("localhost",8888);
        }
        catch(UnknownHostException e){
            System.err.println("Unknown host:localhost.");
            System.exit(1);
        }
        catch(IOException e){
            System.err.println("Could not connect to localhost.");
            System.exit(1);
        }
        File file=new File("file_to_send.txt");
        FileInputStream in=new FileInputStream(file);
        OutputStream out=socket.getOutputStream();
        byte[]bytes=new byte[1024];
        int count;
        while((count=in.read(bytes))>0){
            out.write(bytes,0,count);
        }
        out.close();
        in.close();
        socket.close();
    }
}
