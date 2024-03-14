package br.com.will.macdonalts.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(
        @NotBlank(message = "nome não pode ser null")
        String nome,
        @NotNull(message = "preco não pode ser null")
        Float preco,
        @NotNull(message = "categoria não pode ser null")
        Categoria categoria) {
    public ProdutoDto(Produto p) {
        this(p.getNome(),p.getPreco(),p.getCategoria());
    }

}
