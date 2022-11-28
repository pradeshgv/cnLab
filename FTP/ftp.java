import java.io.*;

public class ftp {
    public static void main(String args[]) throws Exception {
        FileInputStream fin = new FileInputStream("C:\\Users\\prade\\Downloads\\Practice\\FTP\\Full Stack TT.PNG");
        FileOutputStream fout = new FileOutputStream("C:\\Users\\prade\\Downloads\\Practice\\FTP\\44.PNG");
        byte b[] = new byte[4 * 1024];
        int a = 0;
        while ((a = fin.read(b)) != -1) {
            fout.write(b);
        }
    }

}
