package br.com.will.macdonalts.domain.produto;

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

    public Produto(ProdutoDto produto) {
        this.nome = produto.nome();
        this.preco = produto.preco();
        this.categoria = produto.categoria();
    }
}
