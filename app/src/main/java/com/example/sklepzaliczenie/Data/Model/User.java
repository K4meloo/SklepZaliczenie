package com.example.sklepzaliczenie.Data.Model;

import android.content.Context;

import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.R;

public class User {
    private Context context;

    public final static int USER_TYPE_ADMIN = 1;
    public final static int USER_TYPE_USER = 2;
    public final static int USER_TYPE_GUEST = 3;

    private int id;
    private int userType;
    private String name;
    private String surname;
    private String email;

    public User(int userType, String name, String surname, String email) {
        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public User(int id, int userType, String name, String surname, String email) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public User(Context context) {
        this.userType = USER_TYPE_GUEST;
        this.name = context.getResources().getString(R.string.guest);
        this.surname = "";
        this.email = context.getResources().getString(R.string.blank_email);
        this.context = context;
    }
    public int getUserType() {
        return userType;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public static User login(Context context, String email, String password){
        Database database = new Database(context);
        return database.login(email, password);
    }
    public static boolean registerUser(Context context, String name, String surname, String email, String password, int userType){
        Database database = new Database(context);
        return database.registerUser(name, surname, email, password, userType);
    }
}
