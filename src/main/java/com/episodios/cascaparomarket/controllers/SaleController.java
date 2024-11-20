package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dto.ReciboDTO;
import com.episodios.cascaparomarket.dto.VentaDTO;
import com.episodios.cascaparomarket.models.Sale;
import com.episodios.cascaparomarket.repository.ClientRepository;
import com.episodios.cascaparomarket.repository.SaleRepository;
import com.episodios.cascaparomarket.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleRepository saleRepository;
    private final ClientRepository clientRepository;
    private final SaleService saleService;

    @CrossOrigin
    @GetMapping
    public List<Sale> getSales(){
        return saleRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id){
        return this.saleRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody VentaDTO ventaDTO) {
        return clientRepository.findById(ventaDTO.getIdCliente())
                .map(client -> {
                    Sale sale = new Sale();
                    sale.setFecha(ventaDTO.getFecha());
                    sale.setObservacion(ventaDTO.getObservacion());
                    sale.setCliente(client);
                    return ResponseEntity.status(HttpStatus.CREATED).body(saleRepository.save(sale));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale, @PathVariable Long id){
        sale.setId(id);
        return saleRepository.existsById(id)?ResponseEntity.ok(saleRepository.save(sale)):ResponseEntity.notFound().build();
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
    @GetMapping("recibo/{id}")
    public ReciboDTO realizarRecibo (@PathVariable Long id) {
        return this.saleService.reciboDeVenta(id);
    }
}
