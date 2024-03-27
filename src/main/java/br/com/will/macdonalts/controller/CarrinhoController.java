package br.com.will.macdonalts.controller;

import br.com.will.macdonalts.domain.carrinho.CarrinhoDTO;
import br.com.will.macdonalts.domain.usuario.Usuario;
import br.com.will.macdonalts.infra.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @PostMapping
    public ResponseEntity inserirProduto(@Valid @RequestBody CarrinhoDTO carrinhoDTO, @AuthenticationPrincipal Usuario logado){
        return service.inserirProduto(carrinhoDTO, logado);
    }

    @GetMapping
    public ResponseEntity listarProdutosNoCarrinho(@AuthenticationPrincipal Usuario logado){
        return service.listarProdutosNoCarrinho(logado);
    }
}
