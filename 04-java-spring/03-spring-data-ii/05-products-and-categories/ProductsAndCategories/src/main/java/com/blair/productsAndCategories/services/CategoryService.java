package com.blair.productsAndCategories.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.productsAndCategories.models.Category;
import com.blair.productsAndCategories.models.Product;
import com.blair.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getOneCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> getCategoriesNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		categoryRepository.save(category);
	}
}
