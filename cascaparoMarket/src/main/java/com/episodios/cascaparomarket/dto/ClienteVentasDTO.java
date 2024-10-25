package com.episodios.cascaparomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteVentasDTO {
    private Long idCliente;
    private Long idVenta;
    private Double total;
}
