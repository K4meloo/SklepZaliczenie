package com.example.sklepzaliczenie.View;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sklepzaliczenie.MainActivity;
import com.example.sklepzaliczenie.R;

public class BaseFragment extends Fragment {
    private MainActivity mainActivity;

    public BaseFragment() {
        super(R.layout.fragment_base);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
    }
}
