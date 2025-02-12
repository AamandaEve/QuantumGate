package com.listener.impl.mappers;

import com.listener.impl.models.dtos.ProductDTO;
import com.listener.impl.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDTO productDTO);

    ProductDTO toDto(Product product);
}
