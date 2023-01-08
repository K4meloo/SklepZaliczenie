package com.example.sklepzaliczenie.Data.Model;

import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.View.AccountFragment;
import com.example.sklepzaliczenie.View.BaseFragment;
import com.example.sklepzaliczenie.View.CartFragment;
import com.example.sklepzaliczenie.View.LoginFragment;
import com.example.sklepzaliczenie.View.MainFragment;
import com.example.sklepzaliczenie.View.ProductFragment;
import com.example.sklepzaliczenie.View.RegisterFragment;
import com.example.sklepzaliczenie.View.SearchFragment;
import com.example.sklepzaliczenie.View.SettingsFragment;

public class Fragments {
    public static final int FRAGMENT_BASE = 0;
    public static final int FRAGMENT_HOME = 1;
    public static final int FRAGMENT_SEARCH = 2;
    public static final int FRAGMENT_CART = 3;
    public static final int FRAGMENT_SETTINGS = 4;
    public static final int FRAGMENT_ACCOUNT = 5;
    public static final int FRAGMENT_LOGIN = 6;
    public static final int FRAGMENT_REGISTER = 7;
    public static final int FRAGMENT_PRODUCT = 8;
    public static Fragment getFragment(int fragmentId){
        switch (fragmentId){
            case FRAGMENT_HOME:
                return new MainFragment();
            case FRAGMENT_SEARCH:
                return new SearchFragment();
            case FRAGMENT_CART:
                return new CartFragment();
            case FRAGMENT_SETTINGS:
                return new SettingsFragment();
            case FRAGMENT_ACCOUNT:
                return new AccountFragment();
            case FRAGMENT_LOGIN:
                return new LoginFragment();
            case FRAGMENT_REGISTER:
                return new RegisterFragment();
            case FRAGMENT_PRODUCT:
                return new ProductFragment();
            default:
                return new BaseFragment();
        }
    }
}
