package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;
}
