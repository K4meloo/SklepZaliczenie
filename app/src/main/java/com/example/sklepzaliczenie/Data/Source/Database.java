package com.example.sklepzaliczenie.Data.Source;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.sklepzaliczenie.Data.Model.Cart;
import com.example.sklepzaliczenie.Data.Model.Order;
import com.example.sklepzaliczenie.Data.Model.Product;
import com.example.sklepzaliczenie.Data.Model.ProductVRHeadset;
import com.example.sklepzaliczenie.Data.Model.SampleData;
import com.example.sklepzaliczenie.Data.Model.User;
import com.example.sklepzaliczenie.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Database {
    private Context context;
    private FeedReaderDbHelper dbHelper;

    public Database(Context context) {
        this.context = context;
        this.dbHelper = new FeedReaderDbHelper(context);
    }
    public void clearDatabase(){
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 1);
    }
    public void insertSampleData(){
        SampleData sampleData = new SampleData();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        sampleData.getUsers().forEach(user -> {
            db.execSQL("INSERT INTO users (name, surname, email, password, user_type) VALUES ('" + user.getName() + "', '" + user.getSurname() + "', '" + user.getEmail() + "', '" + "123" + "', " + user.getUserType() + ")");
        });
        sampleData.getProducts().forEach(product -> {
            db.execSQL("INSERT INTO products (name, price, description, image, type) VALUES ('" + product.getName() + "', " + product.getPrice() + ", '" + product.getDescription() + "', '" + product.getImage() + "', " + product.getType() + ")");
        });
        sampleData.getOrders().forEach(order -> {
            order.getProducts().forEach(product -> {
                db.execSQL("INSERT INTO orders (user_id, product_id, quantity) VALUES (" + order.getUserId() + ", " + product.getId() + ", " + product.getQuantity() + ")");
            });
        });
    }

    public List<Product> getProducts(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM products", null);
        List<Product> products = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Log.d("Database", "getProducts: " + cursor.getInt(3));
                if (cursor.getInt(3) == 2) {
                    products.add(new ProductVRHeadset(cursor.getInt(0), cursor.getString(1), cursor.getString(4), cursor.getString(7), cursor.getDouble(2), cursor.getInt(6)));
                }
            } while(cursor.moveToNext());
        }
        return products;
    }
    public void close(){
        dbHelper.close();
    }

    public Product getProduct(int productId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM products WHERE _id = " + productId, null);
        if(cursor.moveToFirst()){
            if (cursor.getInt(3) == 2) {
                return new ProductVRHeadset(cursor.getInt(0), cursor.getString(1), cursor.getString(4), cursor.getString(7), cursor.getDouble(2), cursor.getInt(6));
            }
        }
        return null;
    }

    public void addOrder(Cart cart) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int userId = ((MainActivity) context).getUser().getId();
        Date date = new Date();
        cart.getProducts().forEach(product -> {
            db.execSQL("INSERT INTO orders (user_id, product_id, quantity, date) VALUES (" + userId + ", " + product.getId() + ", " + product.getQuantity() + ", '" + date + "')");
        });
    }

    public User login(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'", null);
        if(cursor.moveToFirst()){
            return new User(cursor.getInt(0), cursor.getInt(5), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        return new User(context);
    }

    public List<Order> getOrders(int userId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE _id = " + userId, null);
        List<Order> orders = new ArrayList<>();
        if(cursor.moveToFirst()){
            List<Product> products = new ArrayList<>();
            products.add(getProduct(cursor.getInt(2)));
            orders.add(new Order(userId, products, cursor.getString(4)));
        }
        return orders;
    }

    public boolean registerUser(String name, String surname, String email, String password, int userType) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = '" + email + "'", null);
        if(cursor.moveToFirst()){
            return false;
        }
        db.execSQL("INSERT INTO users (name, surname, email, password, user_type) VALUES ('" + name + "', '" + surname + "', '" + email + "', '" + password + "', " + userType + ")");
        return true;
    }
}