package com.openclassrooms.shop.controller;

import com.openclassrooms.shop.domain.Order;
import com.openclassrooms.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String getOrder(Order order)
    {
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, ModelMap model)
    {
        if (orderService.getCart().getCartLineList().isEmpty()){
            result.reject("cart.empty");
        }
        if (!result.hasErrors()) {
            order.setLines(orderService.getCart().getCartLineList());
            orderService.saveOrder(order);
            orderService.getCart().clear();
            return "orderCompleted";
        } else {
            return "order";
        }
    }

}
