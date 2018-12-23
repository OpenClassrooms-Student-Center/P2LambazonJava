package com.openclassrooms.shop.domain;

public class CartLine {

    private int orderLineID;
    private Product product;
    private int quantity;

    public double getSubtotal() {
        return quantity * product.getPrice();
    }

    public int getOrderLineID() {
        return orderLineID;
    }

    public void setOrderLineID(int orderLineID) {
        this.orderLineID = orderLineID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
