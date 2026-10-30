package com.biolab.ecommerce.controllers;


import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletar(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listaProdutos());
    }
}
