import java.util.*;
import java.net.*;
import java.io.*;

public class httpClient{
    public static void main(String[] args) throws Exception
    {
        Socket s=new Socket("localhost",5000);
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        Scanner in=new Scanner(System.in);
        String setUrl=in.nextLine();
        dos.writeUTF(setUrl);
        String response=(String)dis.readUTF();
        System.out.println("Response:\n"+response);
        s.close();
    }
}