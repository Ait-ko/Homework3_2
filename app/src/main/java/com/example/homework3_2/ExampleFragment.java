package com.example.homework3_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ExampleFragment extends Fragment {
    private TextView textView;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonNext;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        textView = view.findViewById(R.id.textView);
        buttonPlus = view.findViewById(R.id.ButtonPlus);
        buttonMinus = view.findViewById(R.id.ButtonMinus);
        buttonNext = view.findViewById(R.id.nextButton);


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateTextView();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                updateTextView();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNextFragment();

            }
        });


        updateTextView();

        return view;
    }

    private void openNextFragment() {
        NextFragment fragmentNext = new NextFragment();
        Bundle args = new Bundle();
        args.putInt("value", counter);
        fragmentNext.setArguments(args);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentNext)
                .addToBackStack(null)
                .commit();
    }


    private void updateTextView() {
        textView.setText(String.valueOf(counter));
    }

}
