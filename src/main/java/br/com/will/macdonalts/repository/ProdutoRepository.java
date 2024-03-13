package br.com.will.macdonalts.repository;

import br.com.will.macdonalts.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findByNome(String nome);
}
