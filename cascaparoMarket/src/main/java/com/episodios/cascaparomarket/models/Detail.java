package com.episodios.cascaparomarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter

@Table(name = "ventaDetalle")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Sale venta;
    @ManyToOne
    private Product producto;
    private Integer cantidad;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;
}
