package com.ecommerce.product_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "produits")       
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Produit {
    
    @Id
    private String id;

    private String name;

    private String description;

    private double price;

    private int quantity;
    private String category;

    // Méthode pour vérifier la disponibilité du produit
    public boolean isAvailable() {
        return this.quantity > 0;
    }
}

