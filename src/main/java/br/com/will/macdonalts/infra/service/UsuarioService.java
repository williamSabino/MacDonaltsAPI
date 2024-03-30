package br.com.will.macdonalts.infra.service;

import br.com.will.macdonalts.domain.token.TokenJWTDTO;
import br.com.will.macdonalts.domain.usuario.Role;
import br.com.will.macdonalts.domain.usuario.Usuario;
import br.com.will.macdonalts.domain.usuario.UsuarioDTO;
import br.com.will.macdonalts.domain.usuario.UsuarioRegisterDTO;
import br.com.will.macdonalts.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UsuarioService {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenJWTService tokenJWTService;

    public ResponseEntity login(UsuarioDTO usuarioDTO) {
        var token = new UsernamePasswordAuthenticationToken(usuarioDTO.login(),usuarioDTO.senha());
        var auth = manager.authenticate(token);
        var tokenJWT = tokenJWTService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }


    public ResponseEntity register(UsuarioRegisterDTO usuarioRegisterDTO) {
        var senhaEncriptada = new BCryptPasswordEncoder().encode(usuarioRegisterDTO.senha());
        Usuario usuario = new Usuario(usuarioRegisterDTO.login(), senhaEncriptada, usuarioRegisterDTO.role());
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity noLogin() {
        int random = (int) (Math.random() * 1000);
        String user = "user"+random;
        UsuarioRegisterDTO userRegisterDto = new UsuarioRegisterDTO(user, user, Role.USER);
        register(userRegisterDto);
        UsuarioDTO usuarioDTO = new UsuarioDTO(user,user);
        return login(usuarioDTO);
    }
}
