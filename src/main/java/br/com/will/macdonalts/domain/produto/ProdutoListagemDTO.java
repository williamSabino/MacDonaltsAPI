package br.com.will.macdonalts.domain.produto;

public record ProdutoListagemDTO(Long id, String nome, Float preco, Categoria categoria, String imagem) {
    public ProdutoListagemDTO(Produto p){
        this(p.getId(),p.getNome(),p.getPreco(),p.getCategoria(), p.getImagem());
    }
}
