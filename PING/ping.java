import java.util.*;
import java.io.*;

class ping {
    public static void main(String args[]) throws Exception {
        Process p = Runtime.getRuntime().exec("ping 192.168.1.6");
        BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ans = b.readLine();
        while (ans != null) {
            System.out.println(ans);
            ans = b.readLine();
        }

    }
}