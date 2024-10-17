package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Este es el repositorio para la entidad producto
public interface ProductRepository extends JpaRepository<Product, Long> {
}
