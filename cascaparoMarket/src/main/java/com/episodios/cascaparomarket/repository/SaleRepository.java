package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

//Esta es el repositorio para la entidad venta
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
