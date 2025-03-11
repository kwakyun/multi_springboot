package org.example.boot20_sendemail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
public class EmailController{
    @Autowired
    private EmailService emailSender;
    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String sendEmail() {
        log.info("/sendEmail...");
        return "sendEmail";
    }
    @RequestMapping(value = "/sendEmailOK", method = RequestMethod.POST)
    public String sendEmailOK(EmailVO vo) {
        log.info("/sendEmailOK...{}",vo);
        String formattedDate= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        vo.setRegdate(formattedDate);
        try {
            emailSender.SendEmail(vo);
            log.info("SendEmailSuccessed...");
            return "redirect:/";
        } catch (Exception e) {
            log.info("SendEmailFailed...");
            e.printStackTrace();
            return "redirect:sendEmail";
        }
    }
}