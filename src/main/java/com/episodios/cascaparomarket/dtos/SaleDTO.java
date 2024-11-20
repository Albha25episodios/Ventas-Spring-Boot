package com.episodios.cascaparomarket.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class SaleDTO {
    private LocalDate fecha;
    private String observacion;
    private Long idCliente;
}
