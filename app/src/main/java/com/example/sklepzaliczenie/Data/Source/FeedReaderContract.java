package com.example.sklepzaliczenie.Data.Source;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {

    }
    public static final String SQL_CREATE_ENTRIES_USERS =
            "CREATE TABLE " + FeedEntry.TABLE_NAME_USERS + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_USERS_NAME + " TEXT," +
                    FeedEntry.COLUMN_NAME_USERS_SURNAME + " TEXT," +
                    FeedEntry.COLUMN_NAME_USERS_EMAIL + " TEXT," +
                    FeedEntry.COLUMN_NAME_USERS_PASSWORD + " TEXT," +
                    FeedEntry.COLUMN_NAME_USERS_USER_TYPE + " INTEGER)";

    public static final String SQL_CREATE_ENTRIES_PRODUCTS =

            "CREATE TABLE " + FeedEntry.TABLE_NAME_PRODUCTS + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_PRODUCTS_NAME + " TEXT," +
                    FeedEntry.COLUMN_NAME_PRODUCTS_PRICE + " REAL," +
                    FeedEntry.COLUMN_NAME_PRODUCTS_TYPE + " INTEGER, " +
                    FeedEntry.COLUMN_NAME_PRODUCTS_DESCRIPTION + " TEXT," +
                    FeedEntry.COLUMN_NAME_PRODUCTS_IMAGE + " BLOB,"+
                    FeedEntry.COLUMN_NAME_PRODUCTS_QUANTITY + " INTEGER, "+
                    FeedEntry.COLUMN_NAME_PRODUCTS_MANUFACTURER + " TEXT)";

    public static final String SQL_CREATE_ENTRIES_ORDERS =

            "CREATE TABLE " + FeedEntry.TABLE_NAME_ORDERS + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_ORDERS_USER_ID + " INTEGER," +
                    FeedEntry.COLUMN_NAME_ORDERS_PRODUCT_ID + " INTEGER," +
                    FeedEntry.COLUMN_NAME_ORDERS_QUANTITY + " INTEGER," +
                    FeedEntry.COLUMN_NAME_ORDERS_DATE + " TEXT, "+
                    FeedEntry.COLUMN_NAME_ORDERS_STATUS + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES_USERS =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME_USERS;
    public static final String SQL_DELETE_ENTRIES_PRODUCTS =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME_PRODUCTS;
    public static final String SQL_DELETE_ENTRIES_ORDERS =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME_ORDERS;


    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME_USERS = "users";
        public static final String COLUMN_NAME_USERS_NAME = "name";
        public static final String COLUMN_NAME_USERS_SURNAME = "surname";
        public static final String COLUMN_NAME_USERS_EMAIL = "email";
        public static final String COLUMN_NAME_USERS_PASSWORD = "password";
        public static final String COLUMN_NAME_USERS_USER_TYPE = "user_type";

        public static final String TABLE_NAME_PRODUCTS = "products";
        public static final String COLUMN_NAME_PRODUCTS_NAME = "name";
        public static final String COLUMN_NAME_PRODUCTS_PRICE = "price";
        public static final String COLUMN_NAME_PRODUCTS_TYPE = "type";
        public static final String COLUMN_NAME_PRODUCTS_DESCRIPTION = "description";
        public static final String COLUMN_NAME_PRODUCTS_IMAGE = "image";
        public static final String COLUMN_NAME_PRODUCTS_QUANTITY = "quantity";
        public static final String COLUMN_NAME_PRODUCTS_MANUFACTURER = "manufacturer";

        public static final String TABLE_NAME_ORDERS = "orders";
        public static final String COLUMN_NAME_ORDERS_USER_ID = "user_id";
        public static final String COLUMN_NAME_ORDERS_PRODUCT_ID = "product_id";
        public static final String COLUMN_NAME_ORDERS_QUANTITY = "quantity";
        public static final String COLUMN_NAME_ORDERS_DATE = "date";
        public static final String COLUMN_NAME_ORDERS_STATUS = "status";

    }

}
