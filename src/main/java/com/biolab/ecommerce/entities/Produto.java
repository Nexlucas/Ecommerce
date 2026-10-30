package com.biolab.ecommerce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemDoPedido> itens = new HashSet<>();

    public List<Pedido>  getPedido() {
        return itens.stream().map(x -> x.getPedido()).toList();
    }
}
