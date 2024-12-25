package com.example.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

//    DTO stands for date Transfer Object

    private String id;
    private String name;
    private String description;
    private Double price;
}
