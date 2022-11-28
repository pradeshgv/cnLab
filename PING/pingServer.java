import java.util.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author Prasath Karthiban
 */
public class pingServer {
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(5000);
        Socket s=ss.accept();
        if(s.isConnected()){
            System.out.println("Connected...");
        }
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        String ip="";
        int no=0;
        if((dis.readUTF()).equals("P")) no=dis.readInt();
        if((dis.readUTF()).equals("A")){
            ip=dis.readUTF();
            System.out.println(no+"\n"+ip+"\n");
        }
        Process process=Runtime.getRuntime().exec("ping "+ip);
        BufferedReader pis=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String ipline=pis.readLine();
        while(ipline!=null){
            dos.writeUTF(ipline+"\n");
            ipline=pis.readLine();
        }
        dis.close();
        dos.close();
    }
}
