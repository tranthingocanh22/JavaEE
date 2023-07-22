package com.example.basespring.service;

import com.example.basespring.entities.Products;
import com.example.basespring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public Page<Products> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Products> findById(long id) {
        return productRepository.findById(id);
    }
}
