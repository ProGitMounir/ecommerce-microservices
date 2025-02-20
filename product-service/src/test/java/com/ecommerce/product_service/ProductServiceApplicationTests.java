package com.ecommerce.product_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ecommerce.product_service.Dto.ProduitRequest;
import com.ecommerce.product_service.repository.ProduitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper; // Pour la sérialisation et la désérialisation des objets; il vas nous servir a convertir notre produitRequest en JSON
	@Autowired
	private ProduitRepository produitRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynDynamicPropertyRegistry) {
		dynDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduit() throws Exception {
		ProduitRequest produitRequest = getProduitRequest();
		String produitRequestString = objectMapper.writeValueAsString(produitRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/produits")
			.contentType("application/json")
			.content(produitRequestString))
			.andExpect(status().isCreated());
		Assertions.assertEquals(1, produitRepository.findAll().size());
	}

	private ProduitRequest getProduitRequest() {
		return ProduitRequest.builder()
			.name("Produit 1")
			.description("Description 1")
			.price(100)
			.quantity(10)
			.category("Category 1")
			.build();

	}


}
