package com.biolab.ecommerce.repositories;

import com.biolab.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
