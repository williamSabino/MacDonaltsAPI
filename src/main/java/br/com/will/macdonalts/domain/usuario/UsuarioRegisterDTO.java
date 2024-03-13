package br.com.will.macdonalts.domain.usuario;

public record UsuarioRegisterDTO(String login, String senha, Role role) {
}
