package com.nhnghia.entity;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {

    Map<Product, Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void addToCart(Product product, Integer amount) {
        if (this.cart.containsKey(product)) {
            this.cart.put(product, this.cart.get(product) + amount);
        } else {
            this.cart.put(product, amount);
        }
    }

    public void remove(Product product) {
        this.cart.remove(product);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
}
