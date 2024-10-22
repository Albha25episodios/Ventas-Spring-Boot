package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dto.ClienteVentasDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.models.Sale;
import com.episodios.cascaparomarket.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SaleService saleService;

    public List<ClienteVentasDTO> totalVentasPorCliente (Long idCliente) {
        Optional<Client> client = clientRepository.findById(idCliente);
        if(client.isEmpty()){
            throw new RuntimeException("Cliente no encontrado");
        }

        List<ClienteVentasDTO> ventasDTOS = new ArrayList<>();
        List<Sale> sales = client.get().getVentas();
        for (Sale sale : sales) {
            ClienteVentasDTO v = new ClienteVentasDTO();
            v.setIdCliente(sale.getCliente());
            v.setIdVenta(sale.getId());
            v.setTotal(saleService.totalPorVenta(sale.getId()));
            ventasDTOS.add(v);
        }
        return ventasDTOS;
    }
}
