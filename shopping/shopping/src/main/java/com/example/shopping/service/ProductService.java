package com.example.shopping.service;

import com.example.shopping.dto.ProductRequest;
import com.example.shopping.dto.ProductResponse;
import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableMongoRepositories("com.example.shopping.repository")
public class  ProductService {


    @Autowired
    private final ProductRepo productRepo;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepo.save(product);
        log.info("product {} is Saved",product.getId()); // {} is for ID PlaceHolder
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
