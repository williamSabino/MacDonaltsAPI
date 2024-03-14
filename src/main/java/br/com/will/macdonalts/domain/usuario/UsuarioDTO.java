package br.com.will.macdonalts.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank(message = "Login não pode ser null")
        String login,
        @NotBlank(message = "Senha não pode ser null")
        String senha) {
}
