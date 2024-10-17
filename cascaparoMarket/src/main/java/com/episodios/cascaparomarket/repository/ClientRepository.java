package com.episodios.cascaparomarket.repository;

import com.episodios.cascaparomarket.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
