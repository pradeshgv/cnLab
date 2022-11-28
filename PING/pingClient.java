import java.util.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author Prasath Karthiban
 */
public class pingClient {
    public static void main(String[] args)throws Exception{
        Socket client=new Socket("localhost",5000);
        DataInputStream dis=new DataInputStream(client.getInputStream());
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        Scanner in=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n-->");
        int no=in.nextInt();
        System.out.println("ping address-->");
        String ip=br.readLine();
        dos.writeUTF("P");
        dos.writeInt(no);
        dos.writeUTF("A");
        dos.writeUTF(ip);
        String pingRes=dis.readLine();
        while((pingRes)!=null){
            System.out.println(pingRes);
            pingRes=dis.readLine();
        }
        dos.flush();
        dos.close();
        client.close();
    }
}
