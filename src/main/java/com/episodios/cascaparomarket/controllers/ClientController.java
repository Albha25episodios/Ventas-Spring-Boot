package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dtos.ClientDTO;
import com.episodios.cascaparomarket.repositories.ClientRepository;
import com.episodios.cascaparomarket.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")

public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    //this function return all tuples of the table client
    @CrossOrigin
    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getClientsDto();
    }

    //this function find a client by id and return this
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientRepository.existsById(id)?
                ResponseEntity.status(HttpStatus.OK).body(clientService.getClient(id)) :
                ResponseEntity.notFound().build();
    }

    //this function obtain an entity client and save
    @CrossOrigin
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDTO));
    }

    // this function get one tuple by id an update that in the table
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setIdCliente(id);
        return clientRepository.existsById(id)?
                ResponseEntity.status(HttpStatus.OK).body(clientService.saveClient(clientDTO)) :
                ResponseEntity.notFound().build();
    }

    //this function find a client and delete this from the table
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
