package br.com.will.macdonalts.controller;

import br.com.will.macdonalts.domain.usuario.UsuarioDTO;
import br.com.will.macdonalts.domain.usuario.UsuarioRegisterDTO;
import br.com.will.macdonalts.infra.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.login(usuarioDTO);
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UsuarioRegisterDTO usuarioRegisterDTO){
        return usuarioService.register(usuarioRegisterDTO);
    }

    @PostMapping("/noLogin")
    public ResponseEntity noLogin(){
        return usuarioService.noLogin();
    }
}
