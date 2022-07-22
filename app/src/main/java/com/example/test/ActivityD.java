package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test.databinding.ActivityCBinding;
import com.example.test.databinding.ActivityDBinding;

public class ActivityD extends AppCompatActivity {
    ActivityDBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.dTextView.setText("ActivityD_4");
                Intent intent = new Intent(getBaseContext(), ActivityB.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}