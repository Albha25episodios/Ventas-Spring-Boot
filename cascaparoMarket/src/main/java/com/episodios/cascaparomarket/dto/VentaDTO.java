package com.episodios.cascaparomarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VentaDTO {
    private LocalDate fecha;
    private String observacion;
    private Long idCliente;
}
