package com.blair.productsAndCategories.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.productsAndCategories.models.Category;
import com.blair.productsAndCategories.models.Product;
import com.blair.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product getOneProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void createProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		productRepository.save(product);
	}
}
