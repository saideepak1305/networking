import java.io.*;
import java.net.*;
public class http
{
public static void main(String args[])throws IOException
{
URL url=new URL("https://www.google.co.in/");//
URLConnection conn=url.openConnection();
conn.connect();
InputStreamReader content= new InputStreamReader(conn.getInputStream());
FileWriter f=new FileWriter ("abc.html");
for(int i=0;i!=-1;i= content.read())
{
f.write((char) i);
}
}
}