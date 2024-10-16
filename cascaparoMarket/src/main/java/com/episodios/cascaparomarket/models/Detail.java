package com.episodios.cascaparomarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter

public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Sale sale;
    @ManyToOne
    private Product product;
    private Integer quantity;
    @Column(precision = 10, scale = 2)
    private BigDecimal unitPrice;
}
