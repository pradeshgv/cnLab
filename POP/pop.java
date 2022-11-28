import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Message;

public class pop{

    void displayMail(String host,String storageType,String username,String password) throws Exception
    {
        Properties properties=new Properties();
        properties.put("mail.pop3.host",host);
        properties.put("mail.pop3.port","995");
        properties.put("mail.pop3.starttls.enable","true");
        Session session=Session.getDefaultInstance(properties);
        Store store=session.getStore("pop3s");
        store.connect(host,username,password);
        Folder folder=store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message messages[]=folder.getMessages();
        int recent=messages.length-1;
        Message recentMessage=messages[recent];
        recentMessage.writeTo(System.out);
        folder.close();
        store.close();
    }

    public static void main(String[] args)
    {
        String host="pop.gmail.com";
        String storageType="pop3";
        String username="fastridezapp@gmail.com";
        String password="ipur dwdh ohuc lhib";
        displayMail(host,storageType,username,password);
    }
}