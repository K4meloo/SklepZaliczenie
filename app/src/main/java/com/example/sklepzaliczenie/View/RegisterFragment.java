package com.example.sklepzaliczenie.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.Data.Model.Fragments;
import com.example.sklepzaliczenie.Data.Model.User;
import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

public class RegisterFragment extends Fragment {
    private MainActivity mainActivity;

    public RegisterFragment() {
        super(R.layout.fragment_register);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        EditText name = mainActivity.findViewById(R.id.fragment_register_name);
        EditText surname = mainActivity.findViewById(R.id.fragment_register_surname);
        EditText email = mainActivity.findViewById(R.id.fragment_register_email);
        EditText password = mainActivity.findViewById(R.id.fragment_register_password);

        Button registerButton = mainActivity.findViewById(R.id.fragment_register_register);

registerButton.setOnClickListener(v -> {
            String nameText = name.getText().toString();
            String surnameText = surname.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            if (nameText.isEmpty() || surnameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(mainActivity, "uzupełnij dane", Toast.LENGTH_SHORT).show();
            } else {
                if (User.registerUser(mainActivity, nameText, surnameText, emailText, passwordText, 2)) {
                    Toast.makeText(mainActivity, "zarejestrowano", Toast.LENGTH_SHORT).show();
                    mainActivity.showFragment(Fragments.FRAGMENT_ACCOUNT);
                } else {
                    Toast.makeText(mainActivity, "nie udało się zarejestrować", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

