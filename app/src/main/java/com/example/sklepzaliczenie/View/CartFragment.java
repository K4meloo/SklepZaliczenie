package com.example.sklepzaliczenie.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CartFragment extends Fragment {

    private MainActivity mainActivity;
    private Button addToCart;

    public CartFragment() {
        super(R.layout.fragment_cart);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        TextView total = view.findViewById(R.id.fragment_cart_total);
        total.setText(mainActivity.getCart().getTotal() + " zł");

        ListView listView = view.findViewById(R.id.fragment_cart_list_view);
        List<Map<String, String>> productsMap = new ArrayList<>();
        mainActivity.getCart().getProducts().forEach(product-> {
            Map<String, String> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("price", String.valueOf(product.getPrice()));
            productsMap.add(productMap);
        });
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                mainActivity,
                productsMap,
                R.layout.recycler_item,
                new String[]{"name", "price"},
                new int[]{R.id.product_name, R.id.product_price}
        );
        listView.setAdapter(simpleAdapter);

        Button clearCartButton = view.findViewById(R.id.fragment_cart_clear_button);
        clearCartButton.setOnClickListener(v -> {
            mainActivity.clearCart();
Toast.makeText(mainActivity, "Cart cleared", Toast.LENGTH_SHORT).show();
        mainActivity.showFragment(Fragments.FRAGMENT_CART);
        });

        Button buyButton = view.findViewById(R.id.fragment_cart_checkout_button);
        buyButton.setOnClickListener(v -> {
            if (mainActivity.getCart().getProducts().size() > 0 && mainActivity.getUser().getUserType() == 2) {
                Database db = new Database(mainActivity);
                db.addOrder(mainActivity.getCart());
                mainActivity.clearCart();
                Toast.makeText(mainActivity, "Zamówienie zostało złożone", Toast.LENGTH_SHORT).show();
                mainActivity.showFragment(Fragments.FRAGMENT_CART);
            } else {
                Toast.makeText(mainActivity, "Nie można złożyć zamówienia", Toast.LENGTH_SHORT).show();
            }
        });

        Button shareButton = view.findViewById(R.id.fragment_cart_share_button);
        shareButton.setOnClickListener(v -> {
            if (mainActivity.getCart().getProducts().size() > 0) {
                String message = "Zamówienie:\n";
                for (int i = 0; i < mainActivity.getCart().getProducts().size(); i++) {
                    message += mainActivity.getCart().getProducts().get(i).getName() + " - " + mainActivity.getCart().getProducts().get(i).getPrice() + "zł\n";
                }
                message += "Do zapłaty: " + mainActivity.getCart().getTotal() + "zł";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            } else {
                Toast.makeText(mainActivity, "Koszyk jest pusty", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
