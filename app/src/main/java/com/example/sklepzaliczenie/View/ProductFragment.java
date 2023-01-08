package com.example.sklepzaliczenie.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.Data.Model.Product;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

import org.w3c.dom.Text;

public class ProductFragment extends Fragment {
    private MainActivity mainActivity;
    private Product product;

    public ProductFragment() {
        super(R.layout.fragment_product);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        TextView nameText = view.findViewById(R.id.fragment_product_name);
        TextView priceText = view.findViewById(R.id.fragment_product_price);
        TextView descriptionText = view.findViewById(R.id.fragment_product_description);
        int productId = mainActivity.getCurrentProduct();
        Database db = new Database(mainActivity);
        product = db.getProduct(productId);

        nameText.setText(product.getName());
        priceText.setText(String.valueOf(product.getPrice()));
        descriptionText.setText(product.getDescription());

        Button addToCartButton = view.findViewById(R.id.fragment_add_to_cart_button);
        addToCartButton.setOnClickListener(v -> mainActivity.addToCart(product));


    }
}

