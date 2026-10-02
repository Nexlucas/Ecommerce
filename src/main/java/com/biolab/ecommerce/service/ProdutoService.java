package com.biolab.ecommerce.service;

import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.entities.Categoria;
import com.biolab.ecommerce.entities.Produto;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import com.biolab.ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    public String criar(ProdutoDTO dto){
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setImgUrl(dto.getImgUrl());

        Categoria cat = categoriaRepository.getReferenceById(dto.getIdCategoria());
        p.getCategorias().add(cat);

        produtoRepository.save(p);
        return "Produto salvo com sucesso!";
    }

    public String deletar(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produtoRepository.deleteById(id);
        return "Produto deletado com sucesso!";
    }

    public List<ProdutoDTO> listaProdutos() {
        List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map(produto -> new ProdutoDTO(produto.getId(),produto.getNome(),produto.getDescricao(),produto.getPreco(),produto.getImgUrl())).toList();
        return produtos;
    }
}
