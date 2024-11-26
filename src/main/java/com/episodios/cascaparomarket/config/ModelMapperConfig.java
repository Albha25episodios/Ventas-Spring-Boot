package com.episodios.cascaparomarket.config;

import com.episodios.cascaparomarket.dtos.*;
import com.episodios.cascaparomarket.models.Client;
import com.episodios.cascaparomarket.models.Detail;
import com.episodios.cascaparomarket.models.Product;
import com.episodios.cascaparomarket.models.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private ModelMapper mapperToClient(ModelMapper modelMapper) {
        modelMapper.typeMap(Client.class, ClientDTO.class).addMappings(mapper -> {
            mapper.map(Client::getId, ClientDTO::setIdCliente);
            mapper.map(Client::getNombre, ClientDTO::setNombreCliente);
            mapper.map(Client::getDireccion, ClientDTO::setDireccionCliente);
            mapper.map(Client::getTelefono, ClientDTO::setTelefonoCliente);
        });
        return modelMapper;
    }

    private ModelMapper mapperToClientSale(ModelMapper modelMapper) {
        modelMapper.typeMap(Client.class, ClientSaleDTO.class).addMappings(mapper -> {
            mapper.map(Client::getId, ClientSaleDTO::setIdCliente);
            mapper.map(Client::getNombre, ClientSaleDTO::setNombreCliente);
            mapper.map(Client::getDireccion, ClientSaleDTO::setDireccionCliente);
            mapper.map(Client::getTelefono, ClientSaleDTO::setTelefonoCliente);
            mapper.map(Client::getVentas, ClientSaleDTO::setVentasCliente);
        });
        return modelMapper;
    }

    private ModelMapper mapperToSale(ModelMapper modelMapper) {
        modelMapper.typeMap(Sale.class, SaleDTO.class);
        return modelMapper;
    }
    private ModelMapper mapperToDetail(ModelMapper modelMapper) {
        modelMapper.typeMap(Detail.class, DetailDTO.class);
        return modelMapper;
    }
    private ModelMapper mapperToProduct(ModelMapper modelMapper) {
        modelMapper.typeMap(Product.class, ProductDTO.class).addMappings(mapper -> {
            mapper.map(Product::getId, ProductDTO::setIdProducto);
            mapper.map(Product::getNombre, ProductDTO::setNombreProducto);
            mapper.map(Product::getDescripcion, ProductDTO::setDescripcionProducto);
            mapper.map(Product::getPrecioUnitario, ProductDTO::setPrecioUnitarioProducto);
        });
        return modelMapper;
    }

    @Bean("clientMapper")
    public ModelMapper clientModelMapper() {
        return mapperToClient(this.modelMapper());
    }
    @Bean("saleMapper")
    public ModelMapper saleModelMapper() {
        return mapperToSale(this.modelMapper());
    }
    @Bean("detailMapper")
    public ModelMapper detailModelMapper() {
        return mapperToDetail(this.modelMapper());
    }
    @Bean("productMapper")
    public ModelMapper productModelMapper() {
        return mapperToProduct(this.modelMapper());
    }

    @Bean("fullClientMapper")
    public ModelMapper clienteModelMapper() {
        return mapperToClientSale(this.modelMapper());
    }
}
