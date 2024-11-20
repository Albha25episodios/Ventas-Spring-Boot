package com.episodios.cascaparomarket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class VentaDTO {
    private LocalDate fecha;
    private String observacion;
    private Long idCliente;
}
