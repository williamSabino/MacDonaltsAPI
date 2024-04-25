package br.com.will.macdonalts.repository;

import br.com.will.macdonalts.domain.produto.Categoria;
import br.com.will.macdonalts.domain.produto.Produto;
import br.com.will.macdonalts.domain.produto.ProdutoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findByNome(String nome);

    List<Produto> findAllByCategoria(Categoria categoria);

    @Query("""
            SELECT p FROM Produto p 
            WHERE p.preco >= :preco
            """)
    List<ProdutoDto> listarPorPreco(Integer preco);

    @Query("""
            SELECT p FROM Produto p
            WHERE p.preco <= :preco
            """)
    List<ProdutoDto> listarPorPrecoMenorQuePreco(Integer preco);
}
