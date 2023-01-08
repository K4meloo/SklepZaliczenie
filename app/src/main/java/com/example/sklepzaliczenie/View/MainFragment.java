package com.example.sklepzaliczenie.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Model.Product;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment {

    private MainActivity mainActivity;
    private TextView userText;
    private TextView cartCountText;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();


        Database db = new Database(mainActivity);
        ListView listView = view.findViewById(R.id.list_view);
        List<Product> products = db.getProducts();
        List<Map<String, String>> productsMap = new ArrayList<>();
        for (Product product : products) {
            Map<String, String> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("price", String.valueOf(product.getPrice()));
            productsMap.add(productMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                mainActivity,
                productsMap,
                R.layout.recycler_item,
                new String[]{"name", "price"},
                new int[]{R.id.product_name, R.id.product_price}
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Product product = products.get(position);
            int productId = product.getId();
            mainActivity.setCurrentProduct(productId);
            mainActivity.setFragment(Fragments.FRAGMENT_PRODUCT);
        });

    }


}
