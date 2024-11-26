package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioUnitarioProducto;
}
