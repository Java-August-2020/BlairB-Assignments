package com.blair.productsAndCategories.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blair.productsAndCategories.models.Category;
import com.blair.productsAndCategories.models.Product;
import com.blair.productsAndCategories.services.CategoryService;
import com.blair.productsAndCategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String postProduct(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/categories/new";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String postCategory(@RequestParam("name") String name) {
		Category category = new Category(name);
		categoryService.createCategory(category);
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/{id}")
	public String productDetail(@PathVariable("id") Long id, Model model) {
		Product product = productService.getOneProduct(id);
		if (product != null) {
			model.addAttribute("product", product);
			model.addAttribute("categories", categoryService.getCategoriesNotInProduct(product));
			ArrayList<String> categoriesForProduct = new ArrayList<String>();
//			model.addAttribute("categoriesForProduct", product.getCategories());
//			System.out.println(product.getCategories().get(0).getName());
			
			for (Category category : product.getCategories()) {
				categoriesForProduct.add(category.getName());
//				System.out.println(category.getName());
			}
			System.out.println(categoriesForProduct.toString());
			model.addAttribute("categoriesForProduct", categoriesForProduct);
			return "productDetail.jsp";
		} else {
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/products/{id}")
	public String postProductDetail(@PathVariable("id") Long id, @RequestParam("category") Long categoryId) {
		Category category = categoryService.getOneCategory(categoryId);
		Product product = productService.getOneProduct(id);
		categoryService.addProductToCategory(product, category);
		return "redirect:/products/{id}";
	}
	
	@RequestMapping("/categories/{id}")
	public String categoryDetail(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.getOneCategory(id);
		if (category != null) {
			model.addAttribute("category", category);
			model.addAttribute("products", productService.getProductsNotInCategory(category));
			model.addAttribute("productsForCategory", category.getProducts());
			return "categoryDetail.jsp";
		} else {
			return "redirect:/categories/new";
		}
	}
	
	@PostMapping("/categories/{id}")
	public String postCategoryDetail(@PathVariable("id") Long id, @RequestParam("product") Long productId) {
		Product product = productService.getOneProduct(productId);
		Category category = categoryService.getOneCategory(id);
		productService.addCategoryToProduct(product, category);
		return "redirect:/categories/{id}";
	}
}
