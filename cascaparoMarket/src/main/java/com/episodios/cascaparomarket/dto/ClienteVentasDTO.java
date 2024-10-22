package com.episodios.cascaparomarket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class ClienteVentasDTO {
    private Long idCliente;
    private Long idVenta;
    private BigDecimal total;
}
