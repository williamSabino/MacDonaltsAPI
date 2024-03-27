package br.com.will.macdonalts.repository;

import br.com.will.macdonalts.domain.carrinho.Carrinho;
import br.com.will.macdonalts.domain.carrinho.CarrinhoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<CarrinhoDTO> findByUsuario(String login);
}
