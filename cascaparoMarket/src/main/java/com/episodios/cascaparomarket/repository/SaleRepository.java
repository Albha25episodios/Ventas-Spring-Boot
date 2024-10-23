package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Esta es el repositorio para la entidad venta
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
