package com.example.sklepzaliczenie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sklepzaliczenie.Data.Model.Cart;
import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Model.Product;
import com.example.sklepzaliczenie.Data.Model.User;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.Data.Source.FeedReaderDbHelper;
import com.example.sklepzaliczenie.View.AccountFragment;
import com.example.sklepzaliczenie.View.BaseFragment;
import com.example.sklepzaliczenie.View.CartFragment;
import com.example.sklepzaliczenie.View.MainFragment;
import com.example.sklepzaliczenie.View.SearchFragment;
import com.example.sklepzaliczenie.View.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private int cartCount = 0;
    private User user;
    private int currentFragment = 0;
    private List<Integer> visitedFragments;
    private boolean isBackButtonPressed = false;
    private boolean keepLoggedIn = false;
    private int currentProduct = 0;
    private Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        Database database = new Database(this);
        database.clearDatabase();
        database.insertSampleData();
        database.close();

        // handle saved instance state (when activity is recreated)
        if(savedInstanceState != null){
            cartCount = savedInstanceState.getInt("cartCount");
            currentFragment = savedInstanceState.getInt("currentFragment");
            visitedFragments = (List<Integer>) savedInstanceState.getSerializable("visitedFragments");

            if(savedInstanceState.getInt("userType") == User.USER_TYPE_GUEST){
                user = new User(getApplicationContext());
            } else {
                user = new User(savedInstanceState.getInt("userType") ,savedInstanceState.getString("name"), savedInstanceState.getString("surname"), savedInstanceState.getString("email"));
            }
        } else {
            visitedFragments = new ArrayList<>();
            cartCount = 0;
            setFragment(Fragments.FRAGMENT_HOME);
            user = new User(getApplicationContext());
            keepLoggedIn = false;
        }

        cart = new Cart();



        // handle going to correct fragment from shortcut
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String activity = data.toString();
            switch (activity) {
                case "search":
                    currentFragment = Fragments.FRAGMENT_SEARCH;
                    bottomNavigationView.setSelectedItemId(R.id.navigation_search);
                    break;
                case "cart":
                    currentFragment = Fragments.FRAGMENT_CART;
                    bottomNavigationView.setSelectedItemId(R.id.navigation_cart);
                    break;
                case "settings":
                    currentFragment = Fragments.FRAGMENT_SETTINGS;
                    bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
                    break;
                case "account":
                    currentFragment = Fragments.FRAGMENT_ACCOUNT;
                    bottomNavigationView.setSelectedItemId(R.id.navigation_account);
                    break;
                default:
                    currentFragment = Fragments.FRAGMENT_HOME;
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                    break;
            }
        }

        // handle saved instance state for fragments
        showFragment(currentFragment);




        // handle bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    setBottomFragment(1, !isBackButtonPressed);
                    break;
                case R.id.navigation_search:
                    setBottomFragment(2, !isBackButtonPressed);
                    break;
                case R.id.navigation_cart:
                    setBottomFragment(3, !isBackButtonPressed);
                    break;
                case R.id.navigation_settings:
                    setBottomFragment(4, !isBackButtonPressed);
                    break;
                case R.id.navigation_account:
                    setBottomFragment(5, !isBackButtonPressed);
                    break;
                default:
                    setBottomFragment(0, !isBackButtonPressed);
                    break;
            }
            return true;
        });
    }


    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }
    public int getCartCount() {
        return cartCount;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    protected void onNightModeChanged(int mode) {
        super.onNightModeChanged(mode);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (keepLoggedIn) {
            user = new User(savedInstanceState.getInt("userType") ,savedInstanceState.getString("name"), savedInstanceState.getString("surname"), savedInstanceState.getString("email"));
            keepLoggedIn = savedInstanceState.getBoolean("keepLoggedIn");
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("keepLoggedIn", keepLoggedIn);

        outState.putInt("cartCount", cartCount);
        outState.putInt("currentFragment", currentFragment);
        outState.putSerializable("visitedFragments", (Serializable) visitedFragments);

        // if user is guest then save only type
        if (user.getUserType() == User.USER_TYPE_GUEST){
            outState.putInt("userType", user.getUserType());
        } else {
            outState.putInt("userType", user.getUserType());
            outState.putString("name", user.getName());
            outState.putString("surname", user.getSurname());
            outState.putString("email", user.getEmail());
        }
    }
    public void setFragment(int fragment){
        visitedFragments.add(fragment);
        currentFragment = fragment;
        showFragment(fragment);
    }
    public boolean isKeepLoggedIn() {
        return keepLoggedIn;
    }
    public void setKeepLoggedIn(boolean keepLoggedIn) {
        this.keepLoggedIn = keepLoggedIn;
    }
    public void showFragment(int fragment){
        getSupportFragmentManager().beginTransaction().setCustomAnimations(
                R.anim.fade_in,
                R.anim.fade_out
        ).replace(R.id.fragment_container, Fragments.getFragment(fragment)).commit();
    }
    private void setBottomFragment(int fragment, boolean addToHistory) {
        if (addToHistory) {
            visitedFragments.add(fragment);
        }
        currentFragment = fragment;
        showFragment(fragment);
    }
    @Override
    public void onBackPressed() {
        if (visitedFragments.size() > 1){
            visitedFragments.remove(visitedFragments.size() - 1);
            currentFragment = visitedFragments.get(visitedFragments.size() - 1);
            isBackButtonPressed = true;
            switch (currentFragment) {
                case 1:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                    break;
                case 2:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_search);
                    break;
                case 3:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_cart);
                    break;
                case 4:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
                    break;
                case 5:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_account);
                    break;
                default:
                    showFragment(currentFragment);

            }
            isBackButtonPressed = false;
//            showFragment(currentFragment); // show last fragment

        } else {
            super.onBackPressed();
        }
    }
    public void setCurrentProduct(int product){
        this.currentProduct = product;
    }
    public int getCurrentProduct(){
        return currentProduct;
    }
    public void addToCart(Product product){
        cart.addProduct(product);
    }
    public Cart getCart(){
        return cart;
    }

    public void clearCart() {
        cart = new Cart();
    }
}