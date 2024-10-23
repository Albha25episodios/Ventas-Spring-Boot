package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.repository.SaleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    //CONSTRUCTOR
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    //*********************************** MéTODOS ***********************************
    public Double totalPorVenta (Long idVenta) {
        return saleRepository.findById(idVenta)
                .map(sale -> sale.getDetails().stream().mapToDouble(detail -> detail.getPrecioUnitario()*detail.getCantidad()).sum())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}

