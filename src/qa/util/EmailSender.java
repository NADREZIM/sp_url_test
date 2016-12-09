package qa.util;

import qa.util.reporting.Reporter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by User on 09.12.2016.
 */
public class EmailSender {
    static final String username = "jane@sprayable.co";
    static final String password = "Lt8PgRKs";
    public void sendMail(List<String> sites) {
        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("artem.borisov260@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("first_receptionist@mail.ru,second_receptionist@mail.ru"));

            message.setSubject("Broken address");
            for (String element: sites) {
                stringBuilder.append("\n").append(index).append(". ").append(element);
                index++;
            }
            String s = new String(stringBuilder);
            message.setText(s);

            Transport.send(message);

            Reporter.log("mail successfully sent");

        } catch (MessagingException e) {
            Reporter.log("Exception in 'sendMail()' method " + e);
        }
    }
}
