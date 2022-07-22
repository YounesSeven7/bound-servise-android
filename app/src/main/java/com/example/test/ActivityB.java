package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.test.databinding.ActivityBBinding;

public class ActivityB extends AppCompatActivity {
    ActivityBBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Log.d("younes", "younes");
        binding.bTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.bTextView.setText("ActivityB_2");
                Intent intent = new Intent(getBaseContext(), ActivityC.class);
                startActivity(intent);
            }
        });
    }
}