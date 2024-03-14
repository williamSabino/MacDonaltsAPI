package br.com.will.macdonalts.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRegisterDTO(
        @NotBlank(message = "Login não pode ser null")
        String login,
        @NotBlank(message = "Senha não pode ser null")
        String senha,
        @NotNull(message = "Role não pode ser null")
        Role role) {
}
