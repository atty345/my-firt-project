package com.example.shopping.controller;

import com.example.shopping.dto.ProductRequest;
import com.example.shopping.dto.ProductResponse;
import com.example.shopping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {

        productService.createProduct(productRequest);
    }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<ProductResponse> getAllProducts(){
            return productService.getAllProducts();
        }
    }

