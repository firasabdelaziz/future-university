package tn.esprit.futureuniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailServiceInterface {

    @Autowired
    private JavaMailSender mailSender;



    public void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true); // true for HTML content

        mailSender.send(message);
    }



    @Override
    public void sendPasswordResetEmail(String email, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset");
        message.setText("Use the following link to reset your password: http://localhost:4200/reset-password?token=" + resetToken);
        mailSender.send(message);
    }

    @Override
    public void sendVerificationEmail(String email, String verificationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email Verification");
        message.setText("Use the following link to verify your email: http://localhost:8888/verify-email?email=" + email + "&token=" + verificationToken);
        mailSender.send(message);
    }
}
