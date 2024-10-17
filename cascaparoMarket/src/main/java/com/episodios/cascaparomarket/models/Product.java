package com.episodios.cascaparomarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter

@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;
}
