package com.example.colorpage;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btn_change;
    ConstraintLayout main_layout;
    Testviewmodel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_main));
        Objects.requireNonNull(getSupportActionBar()).setTitle("on off app");
        btn_change = findViewById(R.id.btn_change);
        main_layout = findViewById(R.id.main_layout);
        viewModel = new ViewModelProvider(this).get(Testviewmodel.class);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (viewModel.OurrentState.getValue() == null) {
                    viewModel.OurrentState.setValue(String.valueOf(true));
                }
                viewModel.currentState.setValue(!viewModel.currentState.getValue());
            }
        });
        viewModel.currentState.observe(this, new Observer<Boolean>() {
            @SuppressLint("ResourceType")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    btn_change.setText(R.id.turnon);
                    main_layout.setBackgroundColor(getColor(R.color.green));
                } else {
                    btn_change.setText(R.id.turnoff);
                    main_layout.setBackgroundColor(getColor(R.color.red));
                }
            }
        });
    }
}