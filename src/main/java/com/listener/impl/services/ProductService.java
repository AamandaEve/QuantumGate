package com.listener.impl.services;

import com.listener.impl.mappers.ProductMapper;
import com.listener.impl.models.dtos.ProductDTO;
import com.listener.impl.models.entities.Product;
import com.listener.impl.models.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDTO> findAll(){
        return findAll();
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO){
        productDTO.setId(null);
        Product product = mapper.toEntity(productDTO);
        repository.save(product);
        return mapper.toDto(product);
    }

    @Transactional
    public ProductDTO update(UUID id, ProductDTO productDTO){
        Product product = repository.findById(productDTO.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Product entity = mapper.toEntity(productDTO);
        entity.setId(product.getId());
        repository.save(entity);
        return mapper.toDto(entity);
    }

    public void delete(UUID id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        repository.deleteById(id);
    }

}
