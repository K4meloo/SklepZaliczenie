package com.example.sklepzaliczenie.Data.Model;

public class ProductVRHeadset extends Product{

    public ProductVRHeadset(String name, String description, String manufacturer, double price, int quantity, String image) {
        this.type = PRODUCT_TYPE_HEADSET;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }
    public ProductVRHeadset(String name, String description, String manufacturer, double price, int quantity) {
        this.type = PRODUCT_TYPE_HEADSET;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }
    public ProductVRHeadset(int id, String name, String description, String manufacturer, double price, int quantity) {
        this.type = PRODUCT_TYPE_HEADSET;
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    }
