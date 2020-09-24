package cucumberHooks;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class addonFunctions {
    public static void SendMail()  {
        String to = "sohail.abbas@sofbang.com";
        String from = "sohail.abbas@sofbang.com";
        String host = "smtp.office365.com";
        String port = "25";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.username", "sohail.abbas@sofbang.com");
        properties.setProperty("mail.smtp.password", "@Zindagi$July2020");

        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("This is the Subject Line!");
            message.setText("This is actual message");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }



}