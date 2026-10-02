package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.PedidoDTO;
import com.biolab.ecommerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody PedidoDTO dto){
        return ResponseEntity.ok(service.criarPedido(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delOrder(@PathVariable long id){
        service.deletarPedido(id);
        return ResponseEntity.ok("Pedido deletado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        return ResponseEntity.ok(service.listarPedidos());
    }
}
