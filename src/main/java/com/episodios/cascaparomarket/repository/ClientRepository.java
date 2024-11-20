package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Este es mi repositorio para la entidad clientes
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
