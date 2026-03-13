package com.example.produto.service;

import com.example.produto.model.ProdutoModel;
import com.example.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criar(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listar(){
        return produtoRepository.findAll();
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        return produtoRepository.save(model);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
}
