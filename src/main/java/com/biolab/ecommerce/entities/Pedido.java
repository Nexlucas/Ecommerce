package com.biolab.ecommerce.entities;

import com.biolab.ecommerce.entities.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant momento;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @ManyToOne
    private Usuario cliente;
    @OneToOne(mappedBy = "pedido" , cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemDoPedido> itens = new HashSet<>();

    public List<Produto> getProdutos() {
        return itens.stream().map(x -> x.getProduto()).toList();
    }
}
