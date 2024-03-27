package br.com.will.macdonalts.infra.service;

import br.com.will.macdonalts.domain.carrinho.Carrinho;
import br.com.will.macdonalts.domain.carrinho.CarrinhoDTO;
import br.com.will.macdonalts.domain.usuario.Usuario;
import br.com.will.macdonalts.repository.CarrinhoRepository;
import br.com.will.macdonalts.repository.ProdutoRepository;
import br.com.will.macdonalts.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity inserirProduto(CarrinhoDTO carrinhoDTO, Usuario logado) {
        System.out.println("#################################" + carrinhoDTO);
        var produto = produtoRepository.getReferenceById(carrinhoDTO.produto_id());
        var carrinho = new Carrinho(carrinhoDTO.quantidade(), produto, logado.getLogin());
        carrinhoRepository.save(carrinho);
        return ResponseEntity.ok(carrinho);
    }

    public ResponseEntity listarProdutosNoCarrinho(Usuario logado) {
        List<CarrinhoDTO> produtos = carrinhoRepository.findByUsuario(logado.getLogin());

        List<Carrinho> listaCarrinho = produtos.stream()
                .map(c -> new Carrinho(c.id(), c.quantidade(), logado.getLogin(),produtoRepository.getReferenceById(c.produto_id())))
                .toList();
        return ResponseEntity.ok(listaCarrinho);
    }
}
