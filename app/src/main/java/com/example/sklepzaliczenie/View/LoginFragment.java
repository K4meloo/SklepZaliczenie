package com.example.sklepzaliczenie.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Model.User;
import com.example.sklepzaliczenie.Data.Source.Database;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

public class LoginFragment extends Fragment {
    MainActivity mainActivity;
    EditText nameText;
    EditText userTypeText;
    Button loginButton;
    CheckBox rememberMeCheckbox;

    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        nameText = view.findViewById(R.id.input_account_name);
        userTypeText = view.findViewById(R.id.input_user_type);
        loginButton = view.findViewById(R.id.login_button_fragment);
        rememberMeCheckbox = view.findViewById(R.id.keep_logged_in_checkbox);

        loginButton.setOnClickListener(v -> {
            String email = nameText.getText().toString();
            String password = userTypeText.getText().toString();
            boolean rememberMe = rememberMeCheckbox.isChecked();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(mainActivity, "uzupełnij dane", Toast.LENGTH_SHORT).show();
            } else {
                mainActivity.setKeepLoggedIn(rememberMe);
                mainActivity.setUser(User.login(mainActivity, email, password));
                mainActivity.showFragment(Fragments.FRAGMENT_ACCOUNT);
                nameText.setText(mainActivity.getUser().getName()+ " " + mainActivity.getUser().getSurname());
                userTypeText.setText(mainActivity.getUser().getEmail());
                Toast.makeText(mainActivity, "zalogowano", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
