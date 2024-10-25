package com.episodios.cascaparomarket.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TotalProductosDTO {
    private Long idProducto;
    private String nombreProducto;
    private Integer totalComprado;
}
