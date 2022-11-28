import java.util.*;
import java.net.*;
import java.io.*;

public class httpServer{

    static String sendResponce(String req) throws IOException{
        URL url=new URL(req);
        HttpURLConnection con=(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Google Chrome");
        int responceCode=con.getResponseCode();
        System.out.println("Working...");
        if(responceCode==HttpURLConnection.HTTP_OK){
            BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responce=new StringBuffer();
            while((inputLine=in.readLine())!=null)
            {
                // System.out.println(inputLine);
                responce.append(inputLine);
            }
            in.close();
            return responce.toString();
        }
        else{
            System.out.println("GET Request Not Working...");
            return null;
        }
    }

    public static void main(String[] args) throws Exception
    {
        ServerSocket ss=new ServerSocket(5000);
        while(true){
            Socket s=ss.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            String request=(String)dis.readUTF();
            System.out.println(request);
            dos.writeUTF(sendResponce(request));
            // s.close();
        }
        // ss.close();
    }
}