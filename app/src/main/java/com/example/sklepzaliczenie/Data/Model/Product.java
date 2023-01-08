package com.example.sklepzaliczenie.Data.Model;

public abstract class Product {
    public static final int PRODUCT_TYPE_GENERIC = 0;
    public static final int PRODUCT_TYPE_GAME = 1;
    public static final int PRODUCT_TYPE_HEADSET = 2;
    public static final int PRODUCT_TYPE_APP = 3;
    public static final int PRODUCT_TYPE_ACCESSORY = 4;
    public static final int PRODUCT_TYPE_OTHER = 5;

    protected int id;
    protected String name;
    protected String description;
    protected String image = null;
    protected String manufacturer;
    protected double price;
    protected int quantity;
    protected int type;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getImage() {
        return image;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getType() {
        return type;
    }
    public int getId() {
        return id;
    }
}
