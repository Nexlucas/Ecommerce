package com.biolab.ecommerce.DTOs;

import com.biolab.ecommerce.entities.Usuario;
import com.biolab.ecommerce.entities.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private long id;
    private Instant momento;
    private StatusPedido status;
    private long idCliente;

    public PedidoDTO(long idCliente) {
        this.momento = Instant.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.idCliente = idCliente;
    }

    public PedidoDTO(long id, Instant momento, StatusPedido status) {
        this.id = id;
        this.momento = momento;
        this.status = status;
    }
}
