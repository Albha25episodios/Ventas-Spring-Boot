package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dtos.ClientDTO;
import com.episodios.cascaparomarket.dtos.ClienteVentasDTO;
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
    private final SaleService saleService;
    private final ModelMapper modelMapper;

    //*********************************************** MÉTODOS ***********************************************

    public List<ClienteVentasDTO> totalVentasPorCliente (Long idCliente) {
        return clientRepository.findById(idCliente)
                .map(client -> client.getVentas().stream().map(sale -> new ClienteVentasDTO(
                        sale.getCliente(),
                        sale.getId(),
                        saleService.totalPorVenta(sale.getId())))
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public ClientDTO convertToDto (Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public List<ClientDTO> getClientsDto() {
        return clientRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
