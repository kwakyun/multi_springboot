package org.example.boot21_memberemail.email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailSender;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String sendEmail() {
        log.info("/sendEmail...");
        return "sendEmail_login";
    }

    @RequestMapping(value = "/sendEmailOK", method = RequestMethod.POST)
    public String sendEmailOK(EmailVO vo) {
        log.info("/sendEmailOK...{}", vo);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        vo.setRegdate(formattedDate);



        try {
            // 이메일 발송 서비스에 비밀번호 포함된 vo 객체 전달
            emailSender.SendEmail(vo);
            log.info("SendEmailSuccessed...");
            return "redirect:/";
        } catch (Exception e) {
            log.info("SendEmailFailed...");
            e.printStackTrace();
            return "redirect:sendEmail_login";
        }
    }
}
