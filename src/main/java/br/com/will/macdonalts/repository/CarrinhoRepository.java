package br.com.will.macdonalts.repository;

import br.com.will.macdonalts.domain.carrinho.Carrinho;
import br.com.will.macdonalts.domain.carrinho.CarrinhoDTO;
import br.com.will.macdonalts.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<CarrinhoDTO> findByUsuario(String login);

    @Query("select c from Carrinho c where c.usuario = :logado and c.produto = :produto")
    Optional<Carrinho> usuarioContainProduto(String logado, Produto produto);

    @Modifying
    @Query("DELETE FROM Carrinho c WHERE c.usuario = :login and c.produto = :produto")
    void deletarProduto(String login, Produto produto);
}
