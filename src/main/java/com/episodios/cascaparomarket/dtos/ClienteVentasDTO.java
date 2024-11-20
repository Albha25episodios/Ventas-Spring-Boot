package com.episodios.cascaparomarket.dtos;

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
