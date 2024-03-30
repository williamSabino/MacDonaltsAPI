package br.com.will.macdonalts.domain.mail;

public record EmailDetailsDTO(
         String recipient,
         String msgBody,
         String subject,
         String attachment
) {
}
