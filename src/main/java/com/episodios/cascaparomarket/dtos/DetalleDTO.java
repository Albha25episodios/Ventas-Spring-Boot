package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleDTO {
    private ProductoDTO producto;
    private Integer cantidadProducto;
    private Double totalProducto;
}
