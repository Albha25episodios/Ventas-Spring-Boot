package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dtos.ProductDTO;
import com.episodios.cascaparomarket.dtos.TotalProductosDTO;
import com.episodios.cascaparomarket.models.Detail;
import com.episodios.cascaparomarket.models.Product;
import com.episodios.cascaparomarket.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper productMapper;

    //*********************************************** MÉTODOS ***********************************************

    //----------------------calcula la cantidad total vendida de un determinado producto---------------------
    public Integer cantidadTotalPorProducto (Long idProducto) {
        return this.productRepository.findById(idProducto)
                .map(product -> product.getDetails().stream().mapToInt(Detail::getCantidad).sum())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    //-------------------calcula la cantidad total vendida para cada producto que se tiene-------------------
    public List<TotalProductosDTO> cantidadTotalProductos () {
        return this.productRepository.findAll()
                .stream()
                .map(product -> new TotalProductosDTO(
                                product.getId(),
                                product.getNombre(),
                                this.cantidadTotalPorProducto(product.getId())))
                .collect(Collectors.toList());
    }

    public ProductDTO toDto (Product product) {
        return productMapper.map(product, ProductDTO.class);
    }
}
