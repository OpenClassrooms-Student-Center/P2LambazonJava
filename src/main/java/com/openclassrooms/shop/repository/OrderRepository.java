package com.openclassrooms.shop.repository;

import com.openclassrooms.shop.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**

 *
 * @author stanlick
 *
 */

@Repository
public class OrderRepository {

    private List<Order> orders;

    public OrderRepository()
    {
        orders = new ArrayList<Order>();
    }

    /**
     * Saves an order
     * @param order order to be saved
     */
    public void Save(Order order)
    {
        orders.add(order);
    }
}
