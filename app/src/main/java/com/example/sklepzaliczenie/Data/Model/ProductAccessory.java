package com.example.sklepzaliczenie.Data.Model;

public class ProductAccessory extends Product {
    public ProductAccessory(){
        this.type = PRODUCT_TYPE_ACCESSORY;
        this.name = "Accessory";
        this.description = "Accessory";
        this.manufacturer = "Manufacturer";
        this.price = 100.0;
        this.quantity = 1;
    }
}