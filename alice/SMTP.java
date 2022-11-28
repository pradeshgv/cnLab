import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SMTP {
    public static void main(String[] a) throws Exception {
        Properties props = System.getProperties();
        String to = "prasathkarthiban1999@gmail.com",
                from = "kuregamikai@gmail.com",
                password = "aqwigygolxgwmciz";
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("my subject");
        message.setText("hello there!");
        Transport.send(message);
    }
}