package br.com.will.macdonalts.controller;

import br.com.will.macdonalts.domain.mail.EmailDetails;
import br.com.will.macdonalts.domain.mail.EmailDetailsDTO;
import br.com.will.macdonalts.infra.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/sendMail")
    public ResponseEntity sendMail(@RequestBody EmailDetailsDTO details){
        System.out.println("Caiu aqui" + details);
        return emailService.sendSimpleMail(details);
    }

    @PostMapping("/sendMailWhithAttachment")
    public ResponseEntity sendWhithAttachment(@RequestBody EmailDetailsDTO details){
        return emailService.sendMailWhithAttrachment(details);
    }


}
