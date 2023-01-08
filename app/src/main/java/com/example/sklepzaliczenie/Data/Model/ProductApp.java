package com.example.sklepzaliczenie.Data.Model;

public class ProductApp extends Product{
    public ProductApp(){
        this.type = PRODUCT_TYPE_APP;
        this.name = "App";
        this.description = "App";
        this.manufacturer = "Manufacturer";
        this.price = 100.0;
        this.quantity = 10;
    }
}