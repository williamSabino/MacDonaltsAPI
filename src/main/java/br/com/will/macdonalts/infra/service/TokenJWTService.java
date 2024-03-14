package br.com.will.macdonalts.infra.service;

import br.com.will.macdonalts.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenJWTService {

    private String secret;

    public String gerarToken(Usuario usuario){

        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("Macdonalds")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(getExpiresTime())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            return "";
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.require(algorithm)
                    .withIssuer("Macdonalds")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token invalido !");
        }
    }

    private Instant getExpiresTime() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
