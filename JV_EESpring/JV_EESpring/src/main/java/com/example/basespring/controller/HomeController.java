package com.example.basespring.controller;

import com.example.basespring.entities.Products;
import com.example.basespring.entities.Sales;
import com.example.basespring.service.ProductService;
import com.example.basespring.service.SaleService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("home")
@Slf4j
public class HomeController {
    final ProductService productService;
    final SaleService saleService;

    @GetMapping("")
    public String getHomepage() {
        return "v1/views/index";
    }

    @GetMapping("products")
    public String getProducts(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
            Page<Products> products = productService.findAll(pageable);
            model.addAttribute("products", products);
            return "v1/views/products";
        } catch (Exception e) {
            return "/error/404";
        }
    }

    @GetMapping("sales")
    public String getSales(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
            Page<Sales> sales = saleService.findAll(pageable);
            model.addAttribute("sales", sales);
            return "v1/views/sales";
        } catch (Exception e) {
            return "/error/404";
        }
    }

    @GetMapping("sales/{id}")
    public String getSaleById(Model model, @PathVariable("id") long id) {
        try {
            Optional<Sales> sale = saleService.findById(id);
            if (sale.isPresent()){
                model.addAttribute("sale", sale.get());
                return "v1/views/sale-detail";
            }
            return "/error/404";
        } catch (Exception e) {
            return "/error/404";
        }
    }

    @GetMapping("products/{id}")
    public String getProductById(Model model, @PathVariable("id") long id) {
        try {
            Optional<Products> product = productService.findById(id);
            if (product.isPresent()){
                model.addAttribute("product", product.get());
                return "v1/views/product-detail";
            }
            return "/error/404";
        } catch (Exception e) {
            return "/error/404";
        }
    }
}
