package com.biolab.ecommerce.repositories;

import com.biolab.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
