import java.io.*;
import java.net.*;

public class ftpServer{
  public static void main(String[] args)throws Exception{
    ServerSocket ss=new ServerSocket(5000);
    Socket s=ss.accept();
    DataInputStream dis=new DataInputStream(s.getInputStream());
    Long fileSize=dis.readLong();
    String fileName=dis.readUTF();
    FileOutputStream fos=new FileOutputStream(fileName);
    int bytes=0;
    byte[] buffer=new byte[4*1024];
    while(fileSize>0 &&(
      bytes=dis.read(buffer,0,(int)Math.min(buffer.length,fileSize))
    )!=1){
      fos.write(buffer,0,bytes);
      fileSize-=bytes;
    }
    fos.close();
  }
}


// class ftpServer {

//   public static void main(String svi[]) throws IOException {
//     try {
//       ServerSocket servsock = new ServerSocket(105);

//       DataInputStream dis = new DataInputStream(System.in);

//       System.out.println("enter the file name");

//       String fil = dis.readLine();

//       System.out.println(fil + " :is file transfer");

//       File myfile = new File(fil);

//       while (true) {
//         Socket sock = servsock.accept();

//         byte[] mybytearray = new byte[(int) myfile.length()];

//         BufferedInputStream bis = new BufferedInputStream(
//           new FileInputStream(myfile)
//         );

//         bis.read(mybytearray, 0, mybytearray.length);

//         OutputStream os = sock.getOutputStream();

//         os.write(mybytearray, 0, mybytearray.length);

//         os.flush();

//         sock.close();
//       }
//     } catch (Exception saranvi) {
//       System.out.print(saranvi);
//     }
//   }
// }
