package com.example.sklepzaliczenie.Data.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;
    double total;

    public Cart() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public void addProduct(Product product) {
        products.add(product);
        total += product.getPrice();
    }
}
