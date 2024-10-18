package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dto.VentaDTO;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.models.Sale;
import com.episodios.cascaparomarket.repository.ClientRepository;
import com.episodios.cascaparomarket.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ClientRepository clientRepository;

    @CrossOrigin
    @GetMapping
    public List<Sale> getSales(){
        return saleRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id){
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale savedSale = saleRepository.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSale);
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
}
