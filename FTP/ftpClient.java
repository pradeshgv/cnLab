import java.io.*;
import java.net.*;

public class ftpClient{
  public static void main(String[] args) throws Exception{
    Socket client=new Socket("localhost",5000);
    DataOutputStream dos=new DataOutputStream(client.getOutputStream());
    String filePath="C:\\Users\\Admin\\Pictures\\Saved Pictures\\";
    String fileName="22.jpg";
    File file=new File(filePath+fileName);
    FileInputStream fis=new FileInputStream(file);
    dos.writeLong(file.length());
    dos.writeUTF(fileName);
    int bytes=0;
    byte[] buffer=new byte[4*1024];
    while((bytes=fis.read(buffer))!=-1){
      dos.write(buffer,0,bytes);
      dos.flush();
    }
    fis.close();
  }
}


// class ftpClient {

//   public static void main(String svi[]) throws IOException {
//     try {
//       Socket sock = new Socket("localhost", 105);

//       byte[] bytearray = new byte[1024];

//       InputStream is = sock.getInputStream();

//       DataInputStream dis = new DataInputStream(System.in);

//       System.out.println("enter the file name");

//       String fil = dis.readLine();

//       FileOutputStream fos = new FileOutputStream(fil);

//       BufferedOutputStream bos = new BufferedOutputStream(fos);

//       int bytesread = is.read(bytearray, 0, bytearray.length);

//       bos.write(bytearray, 0, bytesread);

//       System.out.println("out.txt file is received");

//       bos.close();

//       sock.close();
//     } catch (Exception SVI) {
//       System.out.print(SVI);
//     }
//   }
// }
