package com.openclassrooms.shop.domain;


import com.openclassrooms.shop.repository.OrderRepository;
import com.openclassrooms.shop.repository.ProductRepository;
import com.openclassrooms.shop.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/*
Unit test of Cart class methods.
Namings follows this convention http://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html
 */

public class CartTest {

    Cart cart;
    ProductRepository productRepository;
    OrderRepository orderRepository ;
    ProductService productService;

    @Before
    public void init() {
        cart = new Cart();
        productRepository = new ProductRepository();
        orderRepository = new OrderRepository();
        productService = new ProductService(productRepository, orderRepository);
    }

    @Test
    public void addItem_twoItemsOfSameProduct_oneLineWithQuantityOfTwoCreated()
    {
        Product product1 = new Product(1L, 0, 20, "name", "description");
        Product product2 = new Product(1L, 0, 20, "name", "description");

        cart.addItem(product1, 1);
        cart.addItem(product2, 1);

        Assert.assertFalse(cart.getCartLineList().isEmpty());
        Assert.assertEquals(1 , cart.getCartLineList().size());
        Assert.assertEquals(2, cart.getCartLineList().get(0).getQuantity());
    }

    @Test
    public void getAverageValue_twoDifferentProductsAdded_averageCalculated()
    {
        List<Product> products = productService.getAllProducts();
        cart.addItem(products.stream().filter(p -> p.getId() == 2).findFirst().get(), 2);
        cart.addItem(products.stream().filter(p -> p.getId() == 5).findFirst().get(), 1);
        double averageValue = cart.getAverageValue();
        double expectedValue = (9.99 * 2 + 895.00) / 3;

        Assert.assertEquals(expectedValue, averageValue, 0);
    }

    @Test
    public void getTotalValue_threeDifferentProductsAdded_totalCalculated()
    {
        List<Product> products = productService.getAllProducts();
        cart.addItem(products.stream().filter(p -> p.getId() == 1).findFirst().get(), 1);
        cart.addItem(products.stream().filter(p -> p.getId() == 4).findFirst().get(), 3);
        cart.addItem(products.stream().filter(p -> p.getId() == 5).findFirst().get(), 1);

        double totalValue = cart.getTotalValue();
        double expectedValue = 92.50 + 32.50 * 3 + 895.00;

        Assert.assertEquals(expectedValue, totalValue, 0);
    }

    @Test
    public void findProductInCartLines_oneProductAdded_productIsFound()
    {
        Product product = new Product(999L, 0, 20, "name", "description");

        cart.addItem(product, 1);
        Product result = cart.findProductInCartLines(999L);

        Assert.assertNotNull(result);
        Assert.assertEquals(999L, result.getId(), 0);
    }

}
