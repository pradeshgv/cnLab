import java.util.*;
import java.io.*;
import java.net.*;

public class dnsClient{
    public static void main(String[] args)
    {
        try{
            DatagramSocket client=new DatagramSocket();
            InetAddress addr=InetAddress.getByName("localhost");
            Scanner in=new Scanner(System.in);
            int port=5000;
            byte[] send=new byte[1024];
            byte[] receive=new byte[1024];
            String request="",response="";
            request=in.nextLine();
            send=request.getBytes();
            DatagramPacket sender=new DatagramPacket(send,send.length,addr,port);
            client.send(sender);
            DatagramPacket receiver=new DatagramPacket(receive,receive.length);
            client.receive(receiver);
            System.out.println(new String(receiver.getData()));
            client.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}