package com.algodomain.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain.assignment.model.Product;
import com.algodomain.assignment.repository.ProductRepository;

@RestController
@RequestMapping("/algodomain")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/addProducts")
	public List<Product> addProducts(@Valid @RequestBody List<Product> product) {
		return productRepository.saveAll(product);
	}

	@PostMapping("/searchProductByName")
	public List<Product> searchProductByName(@RequestParam(name = "product_name") String productName) {
		return productRepository.getProductsByName(productName);
	}

	@PostMapping("/searchProductByNameForSeller")
	public List<Product> searchProductByName(@RequestParam(name = "product_name") String productName,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByName(productName, sellerId);
	}

	@PostMapping("/searchProductByType")
	public List<Product> searchProductByType(@RequestParam(name = "product_type") String productType) {
		return productRepository.getProductsByType(productType);
	}

	@PostMapping("/searchProductByTypeForSeller")
	public List<Product> searchProductByType(@RequestParam(name = "product_type") String productType,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByType(productType, sellerId);
	}

	@PostMapping("/searchProductByCategory")
	public List<Product> searchProductByCategory(@RequestParam(name = "product_category") String productCategory) {
		return productRepository.getProductsByCatgeory(productCategory);
	}

	@PostMapping("/searchProductByCategoryForSeller")
	public List<Product> searchProductByCategory(@RequestParam(name = "product_category") String productCategory,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByCatgeory(productCategory, sellerId);
	}

	@PostMapping("/searchProductByPriceRange")
	public List<Product> searchProductByPriceRange(@RequestParam(name = "min") float min,
			@RequestParam(name = "max") float max) {
		return productRepository.getProductsByRange(min, max);
	}

	@PostMapping("/searchProductByPriceRangeForSeller")
	public List<Product> searchProductByPriceRange(@RequestParam(name = "min") float min,
			@RequestParam(name = "max") float max, @RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByRange(min, max, sellerId);
	}

}
