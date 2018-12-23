package com.openclassrooms.shop.service;

import com.openclassrooms.shop.domain.Cart;
import com.openclassrooms.shop.domain.Order;
import com.openclassrooms.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;
    private Cart cart = new Cart();


    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService)
    {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    /**
     *
     * @param order Order to be saved
     */
    public void saveOrder(Order order)
    {
        order.setDate(LocalDate.now());
        orderRepository.Save(order);
        updateInventory();
    }

    /**
     * Update the product quantities inventory and clears the cart
     */
    private void updateInventory()
    {
        cart.clear();
    }

    /**
     * @return Returns the single instance of cart in the application
     */
    public Cart getCart(){
        return this.cart;
    }
}
