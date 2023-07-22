package com.example.basespring.service;

import com.example.basespring.entities.Products;
import com.example.basespring.entities.Sales;
import com.example.basespring.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {
    final SaleRepository saleRepository;

    public Page<Sales> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public Optional<Sales> findById(long id) {
        return saleRepository.findById(id);
    }
}
