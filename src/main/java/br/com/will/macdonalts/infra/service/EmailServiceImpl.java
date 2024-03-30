package br.com.will.macdonalts.infra.service;

import br.com.will.macdonalts.domain.mail.EmailDetailsDTO;
import br.com.will.macdonalts.domain.mail.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public ResponseEntity sendSimpleMail(EmailDetailsDTO details) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.recipient());
            mailMessage.setText(details.msgBody());
            mailMessage.setSubject(details.subject());

            javaMailSender.send(mailMessage);
            return ResponseEntity.ok("Email Enviado Com Sucesso !");

        } catch (Exception e){
            throw new RuntimeException("Erro ao enviar email" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity sendMailWhithAttrachment(EmailDetailsDTO details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
            try{

                //criando o email
                mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(sender);
                mimeMessageHelper.setTo(details.recipient());
                mimeMessageHelper.setText(details.msgBody());
                mimeMessageHelper.setSubject(details.subject());

                //adicionando o anexo
                FileSystemResource file = new FileSystemResource(new File(details.attachment()));
                mimeMessageHelper.addAttachment(file.getFilename(), file);

                javaMailSender.send(mimeMessage);
                return ResponseEntity.ok("\"Email com anexo enviado com sucesso !\"");
            }catch (Exception e){
                throw new RuntimeException("Erro ao enviar email com anexo");
            }
    }
}
