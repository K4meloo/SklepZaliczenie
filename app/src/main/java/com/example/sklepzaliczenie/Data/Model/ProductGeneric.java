package com.example.sklepzaliczenie.Data.Model;

public class ProductGeneric extends Product {
    public ProductGeneric(){
        this.type = PRODUCT_TYPE_GENERIC;
        this.name = "Generic Product";
        this.description = "Generic Product";
        this.manufacturer = "Manufacturer";
        this.price = 100.0;
        this.quantity = 1;
    }

}
