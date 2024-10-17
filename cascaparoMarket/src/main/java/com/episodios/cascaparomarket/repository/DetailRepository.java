package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

// Este es el repositorio para la entidad detalles
public interface DetailRepository extends JpaRepository<Detail, Long> {
}
