package com.example.produto.controller;

import com.example.produto.model.ProdutoModel;
import com.example.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criar(produtoModel);
        URI url = ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}").buildAndExpand(produtoModel.getId())
                        .toUri();
        return ResponseEntity.created(url).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> requeste = produtoService.listar();
        return ResponseEntity.ok().body(requeste);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id,@RequestBody ProdutoModel produtoModel){;
        return produtoService.atualizar(id, produtoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
