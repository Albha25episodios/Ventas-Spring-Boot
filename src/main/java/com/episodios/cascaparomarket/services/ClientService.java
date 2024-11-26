package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dtos.ClientDTO;
import com.episodios.cascaparomarket.dtos.ClientSaleDTO;
import com.episodios.cascaparomarket.dtos.SaleDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper clientMapper;
    private final ModelMapper fullClientMapper;

    //*********************************************** MÉTODOS ***********************************************

    public ClientDTO convertToClientDto (Client client) {
        return fullClientMapper.map(client, ClientDTO.class);
    }

    public List<ClientDTO> getClientsDto () {
        return clientRepository.findAll().stream().map(this::convertToClientDto).collect(Collectors.toList());
    }

    public ClientDTO getClient (Long id) {
        return clientMapper.map(clientRepository.findById(id), ClientDTO.class);
    }

    public ClientDTO saveClient (ClientDTO clientDTO) {
        return clientMapper.map(clientRepository.save(clientMapper.map(clientDTO, Client.class)), ClientDTO.class);
    }
}
