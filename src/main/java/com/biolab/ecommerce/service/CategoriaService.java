package com.biolab.ecommerce.service;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.entities.Categoria;
import com.biolab.ecommerce.entities.Produto;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public String newCategoria(CategoriaDTO dto){
        Categoria c = new Categoria();
        c.setNome(dto.getNome());
        categoriaRepository.save(c);
        return "Categoria cadastrada com sucesso!";
    }

    public List<CategoriaDTO> listarCategorias(){
        List<CategoriaDTO> categorias = categoriaRepository.findAll().stream().map(categoria ->  new CategoriaDTO(categoria.getId(),categoria.getNome())).toList();
        return categorias;
    }

    public CategoriaDTO buscarID(long id){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        CategoriaDTO dto = new CategoriaDTO(categoria.getId(),categoria.getNome());

        return dto;
    }

    public String deletarID(long id){
        categoriaRepository.deleteById(id);
        return "Categoria removida com sucesso!";
    }
}
