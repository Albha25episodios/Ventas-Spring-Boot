package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
