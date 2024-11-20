package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Este es el repositorio para la entidad producto
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
