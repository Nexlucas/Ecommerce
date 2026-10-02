package com.biolab.ecommerce.service;

import com.biolab.ecommerce.DTOs.PedidoDTO;
import com.biolab.ecommerce.entities.Pedido;
import com.biolab.ecommerce.entities.Usuario;
import com.biolab.ecommerce.entities.enums.StatusPedido;
import com.biolab.ecommerce.repositories.PedidoRepository;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarPedido(PedidoDTO dto) {
        Usuario u = usuarioRepository.findById(dto.getIdCliente()).orElseThrow();
        Pedido p = new Pedido();
        p.setCliente(u);
        p.setMomento(Instant.now());
        p.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedidoRepository.save(p);
        return "Pedido criado com sucesso!";
    }

    public String deletarPedido(long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.deleteById(id);
        return "Pedido deletado com sucesso!";
    }

    public List<PedidoDTO>  listarPedidos() {

        List<PedidoDTO> pedidos = pedidoRepository.findAll().stream().map(pedido -> new PedidoDTO(pedido.getId(),pedido.getMomento(),pedido.getStatus(),pedido.getCliente().getId())).toList();
        return pedidos;
    }

}
