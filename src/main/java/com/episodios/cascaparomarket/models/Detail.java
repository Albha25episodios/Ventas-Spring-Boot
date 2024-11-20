package com.episodios.cascaparomarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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

    private Double precioUnitario;

    public Long getVenta() {
        return venta.getId();
    }
    public Long getProducto() {return producto.getId();}
}
