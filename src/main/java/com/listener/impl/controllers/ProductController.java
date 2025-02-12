package com.listener.impl.controllers;

import com.listener.impl.models.dtos.ProductDTO;
import com.listener.impl.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> save(ProductDTO productDTO){
        return ResponseEntity.ok(service.save(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable("id") UUID id, ProductDTO productDTO){
        return ResponseEntity.ok(service.update(id, productDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
