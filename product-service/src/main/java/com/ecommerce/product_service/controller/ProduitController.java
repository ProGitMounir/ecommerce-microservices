package com.ecommerce.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product_service.Dto.ProduitRequest;
import com.ecommerce.product_service.Dto.ProduitResponse;
import com.ecommerce.product_service.model.Produit;
import com.ecommerce.product_service.service.ProduitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    private final ProduitService produitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produit createProduit(@RequestBody ProduitRequest produitRequest) {
        return produitService.saveproduit(produitRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProduitResponse> getAllProduits() {
        return produitService.getAllProduits();
    }






/* 
    @GetMapping("/{id}")
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("/category/{category}")
    public List<Produit> getProduitsByCategory(@PathVariable String category) {
        return produitService.getProduitsByCategory(category);
    }

    @GetMapping("/price")
    public List<Produit> getProduitsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return produitService.getProduitsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/available")
    public List<Produit> getAvailableProduits() {
        return produitService.getAvailableProduits();
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody ProduitRequest produitRequest) {
        return produitService.updateProduit(id, produitRequest);
    }

    @GetMapping("/unavailable")
    public List<Produit> getUnavailableProduits() {
        return produitService.getUnavailableProduits();
    }

    */
}
