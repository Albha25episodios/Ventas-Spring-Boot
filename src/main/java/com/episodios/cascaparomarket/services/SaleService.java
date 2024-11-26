package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.repositories.ClientRepository;
import com.episodios.cascaparomarket.repositories.ProductRepository;
import com.episodios.cascaparomarket.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    //*********************************** MéTODOS ***********************************

    // --------------- cantidad total pagado por una venta ------------------
    public Double totalPorVenta (Long idVenta) {
        return saleRepository.findById(idVenta)
                .map(sale -> sale.getDetails().stream()
                        .mapToDouble(detail -> detail.getPrecioUnitario()*detail.getCantidad()).sum())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}

