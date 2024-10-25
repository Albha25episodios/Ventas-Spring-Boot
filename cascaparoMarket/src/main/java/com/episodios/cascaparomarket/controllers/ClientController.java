package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dto.ClienteVentasDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.repository.ClientRepository;
import com.episodios.cascaparomarket.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")

public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    //this function return all tuples of the table client
    @CrossOrigin
    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //this function find a client by id and return this
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //this function obtain an entity client and save
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));
    }

    // this function get one tuple by id an update this in the table
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        return clientRepository.existsById(id)? ResponseEntity.ok(clientRepository.save(client)) : ResponseEntity.notFound().build();
    }

    //this function find a client and delete this from the table
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/sales/{id}")
    public List<ClienteVentasDTO> costoVentasPorCliente(@PathVariable Long id) {
        return clientService.totalVentasPorCliente(id);
    }
}
