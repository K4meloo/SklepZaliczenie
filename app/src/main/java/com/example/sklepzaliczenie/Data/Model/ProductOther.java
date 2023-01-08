package com.example.sklepzaliczenie.Data.Model;

public class ProductOther extends Product {
    public ProductOther(){
        this.type = PRODUCT_TYPE_OTHER;
        this.name = "Other";
        this.description = "Other";
        this.manufacturer = "Manufacturer";
        this.price = 100.0;
        this.quantity = 1;
    }
}