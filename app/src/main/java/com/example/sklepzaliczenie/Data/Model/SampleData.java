package com.example.sklepzaliczenie.Data.Model;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    List<Product> products;
    List<User> users;
    List<Order> orders;

    public SampleData(){
        products = new ArrayList<>();
        users = new ArrayList<>();
        orders = new ArrayList<>();

        // Add products
        products.add(new ProductVRHeadset("Oculus Quest 2", "Oculus Quest 2 is our most advanced all-in-one VR system yet. Every aspect of the Quest 2 experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Oculus", 1000.0, 10));
        products.add(new ProductVRHeadset("Oculus Rift S", "Oculus Rift S is our most advanced PC-powered VR headset. Experience the new Oculus Rift S with improved optics, comfort, and ergonomics. With a 5m cable, you can play standing or sitting. The Oculus Rift S is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "Oculus", 1000.0, 10));
        products.add(new ProductVRHeadset("HTC Vive Cosmos", "HTC Vive Cosmos is a premium VR system that lets you explore new worlds and play your favorite games. With a 5m cable, you can play standing or sitting. The HTC Vive Cosmos is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "HTC", 1000.0, 10));
        products.add(new ProductVRHeadset("HTC Vive Pro", "HTC Vive Pro is a premium VR system that lets you explore new worlds and play your favorite games. With a 5m cable, you can play standing or sitting. The HTC Vive Pro is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "HTC", 1000.0, 10));
        products.add(new ProductVRHeadset("HTC Vive Focus Plus", "HTC Vive Focus Plus is a premium VR system that lets you explore new worlds and play your favorite games. With a 5m cable, you can play standing or sitting. The HTC Vive Focus Plus is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "HTC", 1000.0, 10));
        products.add(new ProductVRHeadset("HTC Vive Focus", "HTC Vive Focus is a premium VR system that lets you explore new worlds and play your favorite games. With a 5m cable, you can play standing or sitting. The HTC Vive Focus is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "HTC", 1000.0, 10));
        products.add(new ProductVRHeadset("HTC Vive", "HTC Vive is a premium VR system that lets you explore new worlds and play your favorite games. With a 5m cable, you can play standing or sitting. The HTC Vive is a PC-powered VR headset that’s built for comfort and ease of use. It’s the first headset we’ve designed for our new VR system, Oculus Insight, which enables our highest fidelity positional tracking yet.", "HTC", 1000.0, 10));
        products.add(new ProductVRHeadset("Oculus Go", "Oculus Go is our most advanced all-in-one VR system yet. Every aspect of the Oculus Go experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Oculus", 1000.0, 10));
        products.add(new ProductVRHeadset("Oculus Quest", "Oculus Quest is our most advanced all-in-one VR system yet. Every aspect of the Oculus Quest experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Oculus", 1000.0, 10));
        products.add(new ProductVRHeadset("Oculus Rift", "Oculus Rift is our most advanced all-in-one VR system yet. Every aspect of the Oculus Rift experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Oculus", 1000.0, 10));
        products.add(new ProductVRHeadset("Pimax 8K", "Pimax 8K is our most advanced all-in-one VR system yet. Every aspect of the Pimax 8K experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Pimax", 1000.0, 10));
        products.add(new ProductVRHeadset("Pimax 5K", "Pimax 5K is our most advanced all-in-one VR system yet. Every aspect of the Pimax 5K experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Pimax", 1000.0, 10));
        products.add(new ProductVRHeadset("Pimax 4K", "Pimax 4K is our most advanced all-in-one VR system yet. Every aspect of the Pimax 4K experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Pimax", 1000.0, 10));
        products.add(new ProductVRHeadset("Pimax 2K", "Pimax 2K is our most advanced all-in-one VR system yet. Every aspect of the Pimax 2K experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Pimax", 1000.0, 10));
        products.add(new ProductVRHeadset("Google Daydream View", "Google Daydream View is our most advanced all-in-one VR system yet. Every aspect of the Google Daydream View experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Google", 1000.0, 10));
        products.add(new ProductVRHeadset("Google Daydream", "Google Daydream is our most advanced all-in-one VR system yet. Every aspect of the Google Daydream experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Google", 1000.0, 10));
        products.add(new ProductVRHeadset("Samsung Gear VR", "Samsung Gear VR is our most advanced all-in-one VR system yet. Every aspect of the Samsung Gear VR experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Samsung", 1000.0, 10));
        products.add(new ProductVRHeadset("Samsung Gear VR 2", "Samsung Gear VR 2 is our most advanced all-in-one VR system yet. Every aspect of the Samsung Gear VR 2 experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Samsung", 1000.0, 10));
        products.add(new ProductVRHeadset("Samsung Gear VR 3", "Samsung Gear VR 3 is our most advanced all-in-one VR system yet. Every aspect of the Samsung Gear VR 3 experience has been engineered for maximum performance in a sleek, lightweight design. With a blazing-fast processor, next-level graphics, and a high-resolution display, you’ll experience games and entertainment like never before.", "Samsung", 1000.0, 10));

        // add sample users
        users.add(new User(User.USER_TYPE_USER, "Jan", "Kowalski", "jankowalski@gmail.com"));
        users.add(new User(User.USER_TYPE_USER, "Adam", "Nowak", "adamnowak@gmail.com"));
        users.add(new User(User.USER_TYPE_USER, "Piotr", "Kowalski", "piotrkowalski@gmail.com"));
        users.add(new User(User.USER_TYPE_ADMIN, "Admin", "Admin", "admin@admin.com"));



        // add sample orders
        List<Product> order1Products = new ArrayList<>();
        order1Products.add(products.get(0));
        orders.add(new Order(users.get(0).getId(), order1Products,"2018-01-01", Order.ORDER_TYPE_ORDERED));
        List<Product> order2Products = new ArrayList<>();
        order2Products.add(products.get(1));
        order2Products.add(products.get(2));
        orders.add(new Order(users.get(0).getId(), order2Products,"2018-01-02", Order.ORDER_TYPE_ORDERED));
        List<Product> order3Products = new ArrayList<>();
        order3Products.add(products.get(3));
        order3Products.add(products.get(4));
        order3Products.add(products.get(5));
        orders.add(new Order(users.get(1).getId(), order3Products,"2018-01-03", Order.ORDER_TYPE_DELIVERED));




    }
    public List<Product> getProducts() {
        return products;
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Order> getOrders() {
        return orders;
    }
}
