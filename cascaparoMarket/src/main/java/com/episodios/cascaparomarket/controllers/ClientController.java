package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dto.ClienteVentasDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.repository.ClientRepository;
import com.episodios.cascaparomarket.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

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
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //this function obtain an entity client and save
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    // this function get one tuple by id an update this in the table
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
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
