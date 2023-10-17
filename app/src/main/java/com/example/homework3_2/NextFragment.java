package com.example.homework3_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NextFragment extends Fragment {
    private TextView nextValueTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        nextValueTextView = view.findViewById(R.id.text2);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int value = bundle.getInt("value", 0);
            nextValueTextView.setText("Result: " + value);
        }

        return view;
    }
}
