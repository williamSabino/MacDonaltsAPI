package br.com.will.macdonalts.domain.produto;

import br.com.will.macdonalts.domain.carrinho.Carrinho;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;



    private String imagem;

    public Produto(ProdutoDto produto) {
        this.nome = produto.nome();
        this.preco = produto.preco();
        this.categoria = produto.categoria();
        this.imagem = produto.imagem();
    }
}
