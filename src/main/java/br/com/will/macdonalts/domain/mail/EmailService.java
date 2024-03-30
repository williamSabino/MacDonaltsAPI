package br.com.will.macdonalts.domain.mail;

import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity sendSimpleMail(EmailDetailsDTO details);
    ResponseEntity sendMailWhithAttrachment(EmailDetailsDTO mail);
}
