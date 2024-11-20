package com.episodios.cascaparomarket.repositories;

import com.episodios.cascaparomarket.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Este es el repositorio para la entidad detalles
@Repository
public interface  DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findByVentaId(Long venta_id);
}
