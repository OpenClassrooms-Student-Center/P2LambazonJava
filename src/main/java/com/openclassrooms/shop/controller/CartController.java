package com.openclassrooms.shop.controller;

import com.openclassrooms.shop.domain.Product;
import com.openclassrooms.shop.service.OrderService;
import com.openclassrooms.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CartController {

	private ProductService productService;
	private OrderService orderService;

	@Autowired
	public CartController(ProductService productService, OrderService orderService)
	{
		this.productService = productService;
		this.orderService = orderService;
	}

	@GetMapping("/cart")
	public String getCart(Model model)
	{
		model.addAttribute("cart", orderService.getCart());
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addToCart(@RequestParam("productId") Long productId)
	{
		Product product = productService.getProductById(productId);

		if (product != null) {
			orderService.getCart().addItem(product, 1);
			productService.updateProductQuantities(productId , 1);
			return "redirect:/cart";
		} else {
			return "redirect:/products";
		}
	}

	@PostMapping("cart/remove")
	public String removeFromCart(@RequestBody Long productId)
	{
		Product product = productService.getProductById(productId);

		if (product != null) {
			orderService.getCart().removeLine(product);
		}
		return "redirect:/cart";
	}

}
