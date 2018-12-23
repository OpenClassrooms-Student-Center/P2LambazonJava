package com.openclassrooms.shop.controller;


import com.openclassrooms.shop.domain.Product;
import com.openclassrooms.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("product", new Product());
		return "products";
	}

}
