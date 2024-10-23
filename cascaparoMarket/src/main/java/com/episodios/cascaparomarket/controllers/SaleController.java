package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dto.VentaDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.models.Sale;
import com.episodios.cascaparomarket.repository.ClientRepository;
import com.episodios.cascaparomarket.repository.SaleRepository;
import com.episodios.cascaparomarket.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SaleService saleService;

    @CrossOrigin
    @GetMapping
    public List<Sale> getSales(){
        return saleRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id){
        return saleRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody VentaDTO ventaDTO) {
        return clientRepository.findById(ventaDTO.getIdCliente())
                .map((client1, ventaDTO) -> ResponseEntity.ok(saleRepository.save(new Sale(ventaDTO.getFecha(), ventaDTO.getObservacion(), client1))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale, @PathVariable Long id){
        if(!saleRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        sale.setId(id);
        Sale updateSale = saleRepository.save(sale);
        return ResponseEntity.ok(updateSale);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Sale> deleteSale(@PathVariable Long id){
        if (!saleRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        saleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("{id}/total")
    public Double totalPorVenta(@PathVariable Long id) {
        return saleService.totalPorVenta(id);
    }
}
