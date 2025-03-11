package org.example.boot20_sendemail;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{
    @Autowired
    private JavaMailSender javaMailSender;
    public void SendEmail(EmailVO email) throws Exception {
        MimeMessage msg = javaMailSender.createMimeMessage();
        msg.setSubject(email.getSubject());
        msg.setText(email.getContent() + email.getRegdate());
        msg.setRecipient(MimeMessage.RecipientType.TO,
                new InternetAddress(email.getReciver()));
        javaMailSender.send(msg);
    }
}