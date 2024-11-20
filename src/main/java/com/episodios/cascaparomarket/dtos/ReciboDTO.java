package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReciboDTO {
    private ClientDTO cliente;
    private List<DetalleDTO> detallesVenta;
    private Double valorTotal;
}
