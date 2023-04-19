import java.net.*;
import java.io.*;
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=null;
        try{
            serverSocket=new ServerSocket(8888);
        }
        catch(IOException e){
            System.err.println("Could not listen on port:8888.");
            System.exit(1);
        }
        Socket clientSocket=null;
        try{
            System.out.println("Waiting for connection...");
            clientSocket=serverSocket.accept();
            System.out.println("Accepted connection:"+clientSocket);
        }
        catch(IOException e){
            System.err.println("Accept failed.");
            System.exit(1);
        }
        InputStream in=clientSocket.getInputStream();
        OutputStream out=new FileOutputStream("recieved_file.txt");
        byte[] bytes=new byte[1024];
        int count;
        while((count=in.read(bytes))>0){
            out.write(bytes,0,count);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
