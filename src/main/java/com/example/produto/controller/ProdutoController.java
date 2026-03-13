package com.example.produto.controller;

import com.example.produto.model.ProdutoModel;
import com.example.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criar(@RequestBody ProdutoModel produtoModel){
        return produtoService.criar(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> listar(){
        return produtoService.listar();
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id,@RequestBody ProdutoModel produtoModel){;
        return produtoService.atualizar(id, produtoModel);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }
}
