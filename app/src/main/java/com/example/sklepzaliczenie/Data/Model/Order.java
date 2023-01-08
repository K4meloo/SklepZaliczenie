package com.example.sklepzaliczenie.Data.Model;

import java.util.List;

public class Order {
    public static final int ORDER_TYPE_ORDERED = 0;
    public static final int ORDER_TYPE_IN_PROCESSING = 1;
    public static final int ORDER_TYPE_SENT = 2;
    public static final int ORDER_TYPE_DELIVERED = 3;
    public static final int ORDER_TYPE_CANCELED = 4;


    private int id;
    private int userId;
    private List<Product> products;
    private String date;
    private int status;

    public Order(int id, int userId, List<Product> products, String date, int status) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.date = date;
        this.status = status;
    }
    public Order(int userId, List<Product> products, String date, int status) {
        this.userId = userId;
        this.products = products;
        this.date = date;
        this.status = status;
    }
    public Order(int userId, List<Product> products, String date) {
        this.userId = userId;
        this.products = products;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }


    public String getDate() {
        return date;
    }
    public List<Product> getProducts() {
        return products;
    }
    public int getStatus() {
        return status;
    }
}
