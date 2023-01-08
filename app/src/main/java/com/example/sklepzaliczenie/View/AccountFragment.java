package com.example.sklepzaliczenie.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Model.Order;
import com.example.sklepzaliczenie.Data.Model.Product;
import com.example.sklepzaliczenie.Data.Model.User;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountFragment extends Fragment {
    private MainActivity mainActivity;
    private TextView userNameView;
    private TextView userEmailView;
    private RelativeLayout accountActions;

    public AccountFragment() {
        super(R.layout.fragment_account);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        userNameView = view.findViewById(R.id.account_name);
        userEmailView = view.findViewById(R.id.account_email);

        String displayName = mainActivity.getUser().getName() + " " + mainActivity.getUser().getSurname();
        userNameView.setText(displayName);
        userEmailView.setText(mainActivity.getUser().getEmail());


        // handle account actions visibility
        int currentAccountActions;
        switch (mainActivity.getUser().getUserType()){
            case User.USER_TYPE_GUEST:
                currentAccountActions = R.layout.account_actions_guest;
                break;
            default:
                currentAccountActions = R.layout.account_actions_user;
                break;
        }

        accountActions = view.findViewById(R.id.acccount_actions);
        View child = getLayoutInflater().inflate(currentAccountActions, null);
        accountActions.addView(child);

        if (mainActivity.getUser().getUserType() == User.USER_TYPE_GUEST){
            child.findViewById(R.id.login_button).setOnClickListener(v -> {
                mainActivity.setFragment(Fragments.FRAGMENT_LOGIN);
            });
            child.findViewById(R.id.register_button).setOnClickListener(v -> {
                mainActivity.setFragment(Fragments.FRAGMENT_REGISTER);
            });
        } else {
            child.findViewById(R.id.logout_button).setOnClickListener(v -> {
                mainActivity.setUser(new User(mainActivity));
                mainActivity.showFragment(Fragments.FRAGMENT_ACCOUNT);
                Toast.makeText(mainActivity, "Wylogowano", Toast.LENGTH_SHORT).show();
            });
        }

        if (mainActivity.getUser().getUserType() == User.USER_TYPE_USER){
            ListView ordersList = view.findViewById(R.id.account_list_view);
            Database db = new Database(mainActivity);
            List<Order> orders = db.getOrders(mainActivity.getUser().getId());
            if (orders.size() > 0) {
                List<Map<String, String>> data = new ArrayList<>();
                for (Order order : orders) {
                    Map<String, String> hashData = new HashMap<>();
                    hashData.put("name", "order.getProducts().get(0).getName()");
                    hashData.put("price", "String.valueOf(order.getProducts().get(0).getPrice())");
                    hashData.put("date", order.getDate());
                    data.add(hashData);
                }
                SimpleAdapter adapter = new SimpleAdapter(mainActivity, data, R.layout.order_layout,
                        new String[]{"name", "price", "date"}, new int[]{R.id.order_name, R.id.order_price, R.id.order_date});
                ordersList.setAdapter(adapter);
            }

        }




    }
}
