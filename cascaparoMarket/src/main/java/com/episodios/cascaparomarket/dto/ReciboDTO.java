package com.episodios.cascaparomarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReciboDTO {
    private ClienteDTO cliente;
    private List<DetalleDTO> detallesVenta;
    private Double valorTotal;
}
