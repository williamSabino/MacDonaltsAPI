package br.com.will.macdonalts.domain.carrinho;

import br.com.will.macdonalts.domain.produto.Produto;
import br.com.will.macdonalts.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carrinho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carrinho {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private String usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;


    public Carrinho(Integer quantidade, Produto produto, String usuario) {
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.produto = produto;
    }

}
