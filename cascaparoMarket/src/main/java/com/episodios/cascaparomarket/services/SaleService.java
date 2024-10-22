package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.models.Detail;
import com.episodios.cascaparomarket.models.Sale;
import com.episodios.cascaparomarket.repository.DetailRepository;
import com.episodios.cascaparomarket.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public BigDecimal totalPorVenta (Long idVenta) {
        Optional<Sale> venta = saleRepository.findById(idVenta);
        if(venta.isEmpty()){
            throw new RuntimeException("Venta no encontrada");
        }
        BigDecimal suma = BigDecimal.ZERO;
        List<Detail> detalles = venta.get().getDetails();

        for (Detail detalle : detalles) {
            BigDecimal total = detalle.getPrecioUnitario().multiply(new BigDecimal(detalle.getCantidad()));
            suma = suma.add(total);
        }
        return suma;
    }
}

