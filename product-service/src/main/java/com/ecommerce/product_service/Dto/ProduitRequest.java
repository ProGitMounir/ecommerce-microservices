package com.ecommerce.product_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProduitRequest {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
}