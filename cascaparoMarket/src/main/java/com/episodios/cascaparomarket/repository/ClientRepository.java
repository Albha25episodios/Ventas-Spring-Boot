package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

// Este es mi repositorio para la entidad clientes
public interface ClientRepository extends JpaRepository<Client, Long> {
}
