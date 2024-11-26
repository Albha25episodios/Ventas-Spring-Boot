package com.episodios.cascaparomarket.dtos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientSaleDTO {
    private Long idCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private List<SaleDTO> ventasCliente;
}