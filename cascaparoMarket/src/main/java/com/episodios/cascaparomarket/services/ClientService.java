package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dto.ClienteVentasDTO;
import com.episodios.cascaparomarket.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final SaleService saleService;

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
}
