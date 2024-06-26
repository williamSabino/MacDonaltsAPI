package br.com.will.macdonalts.infra.service;

import br.com.will.macdonalts.domain.produto.Categoria;
import br.com.will.macdonalts.domain.produto.Produto;
import br.com.will.macdonalts.domain.produto.ProdutoDto;
import br.com.will.macdonalts.domain.produto.ProdutoListagemDTO;
import br.com.will.macdonalts.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ResponseEntity listarProdutos(Pageable pageable, String categoria) {
        if(categoria != null){
            var categoriaClass = Categoria.pegarPlural(categoria);
            var listarPorCategoria = repository.findAllByCategoria(categoriaClass);
            var listaProdutosDTO = listarPorCategoria.stream()
                    .map(ProdutoListagemDTO::new)
                    .toList();
            return ResponseEntity.ok().body(listaProdutosDTO);
        }
        var listaProdutos = repository.findAll(pageable);
        var listaProdutosDTO = listaProdutos.stream()
                .map(ProdutoListagemDTO::new)
                .toList();
        return ResponseEntity.ok().body(listaProdutosDTO);
    }

    public ResponseEntity listarProdutoPorPreco(Integer filtro){
        if(filtro > 100){
            var produtos = repository.listarPorPreco(filtro);
            return ResponseEntity.ok(produtos);
        }
        var produtos = repository.listarPorPrecoMenorQuePreco(filtro);
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity detalharProduto(Long id) {
        var produto = repository.findById(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(new ProdutoListagemDTO(produto.get()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity criarProduto(ProdutoDto produtoDto, UriComponentsBuilder uriBuilder) {
        Produto produto = new Produto(produtoDto);
        repository.save(produto);
        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        ProdutoDto produtoCriado = new ProdutoDto(repository.findByNome(produto.getNome()));
        return ResponseEntity.created(uri).body(produtoCriado);
    }


}
