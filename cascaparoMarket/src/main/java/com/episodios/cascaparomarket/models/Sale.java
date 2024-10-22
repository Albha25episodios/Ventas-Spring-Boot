package com.episodios.cascaparomarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "venta")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @Column(columnDefinition = "TEXT")
    private String observacion;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<Detail> details;



    public Long getCliente() {
        return cliente.getId();
    }
}
