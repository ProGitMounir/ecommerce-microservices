package com.ecommerce.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product_service.Dto.ProduitRequest;
import com.ecommerce.product_service.Dto.ProduitResponse;
import com.ecommerce.product_service.model.Produit;
import com.ecommerce.product_service.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // Pour le logging
public class ProduitService {
    @Autowired
    private final ProduitRepository produitRepository;

    public Produit saveproduit(ProduitRequest produitRequest) {
        Produit produit = Produit.builder()
            .name(produitRequest.getName())
            .description(produitRequest.getDescription())
            .price(produitRequest.getPrice())
            .quantity(produitRequest.getQuantity())
            .category(produitRequest.getCategory())
            .build();

        log.info("Produit {} saved successfully", produit.getId());
        return produitRepository.save(produit);
    }

    public List<ProduitResponse> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();

        return produits.stream().map(this::mapToProduitResponse).toList();
    } 
    private ProduitResponse mapToProduitResponse(Produit produit) {
        return ProduitResponse.builder()
            .id(produit.getId())
            .name(produit.getName())
            .description(produit.getDescription())
            .price(produit.getPrice())
            .quantity(produit.getQuantity())
            .category(produit.getCategory())
            .build();
    }

/* 
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public List<Produit> getProduitsByCategory(String category) {
        return produitRepository.findByCategory(category);
    }

    public List<Produit> getProduitsByPriceRange(double minPrice, double maxPrice) {
        return produitRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Produit> getAvailableProduits() {
        return produitRepository.findAvailableProduits();
    }

    public List<Produit> getUnavailableProduits() {
        return produitRepository.findUnavailableProduits();
    }

    public Produit updateProduit(Long id, ProduitRequest produitRequest) {
        Optional<Produit> existingProduct = produitRepository.findById(id);
        if (existingProduct.isPresent()) {
            Produit produit = existingProduct.get();
            produit.setName(produitRequest.getName());
            produit.setDescription(produitRequest.getDescription());
            produit.setPrice(produitRequest.getPrice());
            produit.setQuantity(produitRequest.getQuantity());
            produit.setCategory(produitRequest.getCategory());

            return produitRepository.save(produit);
        }
        return null;
    }
        */
}