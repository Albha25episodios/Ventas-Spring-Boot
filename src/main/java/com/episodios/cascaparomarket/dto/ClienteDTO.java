package com.episodios.cascaparomarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
}
