package br.com.will.macdonalts.controller;

import br.com.will.macdonalts.domain.produto.ProdutoDto;
import br.com.will.macdonalts.infra.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity listarProdutos(@PageableDefault(sort = {"categoria"}) Pageable pageable, String categoria){
        return service.listarProdutos(pageable, categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharProduto(@PathVariable Long id){
        return service.detalharProduto(id);
    }

    @PostMapping
    public ResponseEntity criarProduto(@Valid @RequestBody ProdutoDto produto, UriComponentsBuilder uriBuilder){
        return service.criarProduto(produto, uriBuilder);
    }

}
