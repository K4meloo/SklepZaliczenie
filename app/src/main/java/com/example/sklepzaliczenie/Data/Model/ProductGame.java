package com.example.sklepzaliczenie.Data.Model;

public class ProductGame extends Product {
    public ProductGame(){
        this.type = PRODUCT_TYPE_GAME;
        this.name = "Game";
        this.description = "Game";
        this.manufacturer = "Manufacturer";
        this.price = 100.0;
        this.quantity = 10;
    }
}