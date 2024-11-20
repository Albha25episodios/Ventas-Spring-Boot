package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.models.Detail;
import com.episodios.cascaparomarket.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/details")
public class DetailController {
    @Autowired
    private DetailRepository detailRepository;

    @CrossOrigin
    @GetMapping
    public List<Detail> getDetails() {
        return detailRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Detail> getDetailById(@PathVariable Long id) {
        return detailRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Detail> createDetail(@RequestBody Detail detail) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detailRepository.save(detail));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Detail> updateDetail(@RequestBody Detail detail, @PathVariable Long id) {
        detail.setId(id);
        return detailRepository.existsById(id) ? ResponseEntity.ok(detail) : ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Detail> deleteDetail(@PathVariable Long id) {
        if (!detailRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detailRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/sales/{id}")
    public List<Detail> getAllDetailsBySale(@PathVariable Long id){
        return detailRepository.findByVentaId(id);
    }
}
