package br.com.will.macdonalts.domain.produto;

public record ProdutoDto(String nome, Float preco, Categoria categoria) {
    public ProdutoDto(Produto p) {
        this(p.getNome(),p.getPreco(),p.getCategoria());
    }

}
