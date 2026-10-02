package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUser(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarUsuario(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listaUsuario());
    }
 }
