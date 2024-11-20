package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.repositories.ClientRepository;
import com.episodios.cascaparomarket.repositories.ProductRepository;
import com.episodios.cascaparomarket.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    //*********************************** MéTODOS ***********************************

    // --------------- cantidad total pagado por una venta ------------------
    public Double totalPorVenta (Long idVenta) {
        return saleRepository.findById(idVenta)
                .map(sale -> sale.getDetails().stream()
                        .mapToDouble(detail -> detail.getPrecioUnitario()*detail.getCantidad()).sum())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
    /*
    // ---------------recibo---------------------------
    public ReciboDTO reciboDeVenta (Long idVenta) {
        return saleRepository.findById(idVenta).map(sale -> {
            List<DetalleDTO> detalles = sale.getDetails()
                    .stream().map(detail ->
                            new DetalleDTO(
                                    productRepository.findById(detail.getProducto())
                                            .map(product -> new ProductoDTO(
                                                    product.getNombre(),
                                                    product.getDescripcion(),
                                                    product.getPrecioUnitario()))
                                            .orElseThrow(() -> new RuntimeException("Producto no encontrado")),
                                    detail.getCantidad(),
                                    detail.getPrecioUnitario() * detail.getCantidad())
                    ).toList();
            return new ReciboDTO(
                    clientRepository.findById(sale.getCliente()).map(
                            client -> new ClientDTO(
                                    client.getId(),
                                    client.getNombre(),
                                    client.getDireccion(),
                                    client.getTelefono()
                            )
                    ).orElseThrow(() -> new RuntimeException("Cliente no encontrado")),
                    detalles,
                    detalles.stream().mapToDouble(DetalleDTO::getTotalProducto).sum()
            );
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }*/
}

