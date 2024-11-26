package com.episodios.cascaparomarket.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class SaleDTO {
    private Long id;
    private LocalDate fecha;
    private String observacion;
    private List<DetailDTO> details;
}
