import java.util.*;
import java.net.*;
import java.io.*;

public class dnsServer{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket server=new DatagramSocket(5000);
        byte[] send=new byte[1024];
        byte[] receive=new byte[1024];
        DatagramPacket receiver=new DatagramPacket(receive,receive.length);
        server.receive(receiver);
        String request=(new String(receiver.getData())).trim();
        InetAddress addr=receiver.getAddress();
        int port=receiver.getPort();
        System.out.println(request);
        String response="";
        int flag=0;
        String ip[]={"10.0.0.0","11.1.1.1","12.0.0.0"};
        String name[]={"gmail.com","youtube.com","google.com"};
        for(int i=0;i<ip.length;i++)
        {
            if(request.equals(ip[i])){
                flag=1;
                send=name[i].getBytes();
                System.out.println(name[i]);
                DatagramPacket sender=new DatagramPacket(send,send.length,addr,port);
                server.send(sender);
                break;
            }
            else if(request.equals(name[i])){
                flag=1;
                send=ip[i].getBytes();
                System.out.println(ip[i]);
                DatagramPacket sender1=new DatagramPacket(send,send.length,addr,port);
                server.send(sender1);
                break;
            }
        }
        if(flag==0){
            InetAddress hostName=InetAddress.getByName(request);
            String host=hostName.toString();
            send=host.getBytes();
            DatagramPacket sender3=new DatagramPacket(send,send.length,addr,port);
            server.send(sender3);
        }
        server.close();
    }
}