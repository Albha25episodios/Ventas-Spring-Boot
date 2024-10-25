package com.episodios.cascaparomarket.dto;

import com.episodios.cascaparomarket.models.Product;
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
