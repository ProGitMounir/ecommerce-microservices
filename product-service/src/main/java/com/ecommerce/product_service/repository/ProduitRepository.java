package com.ecommerce.product_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ecommerce.product_service.model.Produit;




public interface ProduitRepository extends MongoRepository<Produit, String> {
    List<Produit> findByCategory(String category);

    List<Produit> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT p FROM Produit p WHERE p.quantity > 0")
    List<Produit> findAvailableProduits();

    @Query("SELECT p FROM Produit p WHERE p.quantity = 0")
    List<Produit> findUnavailableProduits();
    
}
