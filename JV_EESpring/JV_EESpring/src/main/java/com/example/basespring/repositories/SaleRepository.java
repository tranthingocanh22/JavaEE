package com.example.basespring.repositories;

import com.example.basespring.entities.Products;
import com.example.basespring.entities.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Long> {
    Page<Sales> findAll(Pageable pageable);
}
