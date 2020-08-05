package com.yaniv.flightreservation.flightreservation.utilities;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Component
public class Email {


    private JavaMailSender Sender;

    public void sendItnerary(String toAdress , String filepAth)
    {
        MimeMessage message = Sender.createMimeMessage();


        try{
                MimeMessageHelper messahehelper=   new MimeMessageHelper(message , true);
                messahehelper.setTo(toAdress);
                messahehelper.setSubject("Itinerary for your Flight");
                messahehelper.setText("Please find your iternary attached");
                messahehelper.addAttachment("itenarery", new File(filepAth));

            Sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }






}
