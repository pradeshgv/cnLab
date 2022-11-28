import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class smtp{
    public static void main(String[] args)
    {
        Properties properties=System.getProperties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        Session session=Session.getInstance(properties,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("kuregamikai@gmail.com","aqwi gygo lxgw mciz");
            }
        });
        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress("kuregamikai@gmail.com"));
            message.addRecipient(Message.Recipient_Type.TO,new InternetAddress("kuregamikai@gmail.com"));
            message.setSubject("hi");
            message.setText("hello");
            Transport.send(message);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}