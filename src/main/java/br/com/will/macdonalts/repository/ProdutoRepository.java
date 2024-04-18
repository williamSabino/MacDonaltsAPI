package br.com.will.macdonalts.repository;

import br.com.will.macdonalts.domain.produto.Categoria;
import br.com.will.macdonalts.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findByNome(String nome);

    List<Produto> findAllByCategoria(Categoria categoria);
}
