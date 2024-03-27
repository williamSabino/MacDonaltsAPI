package br.com.will.macdonalts.domain.carrinho;

public record CarrinhoDTO(
        Long id,
        Integer quantidade,
        Long produto_id
) {
}
