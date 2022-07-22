package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.databinding.ActivityCBinding;

public class ActivityC extends AppCompatActivity {
    ActivityCBinding binding;

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            int number = ((MyService.LocalBinder) service).number;
            Toast.makeText(getBaseContext(), String.valueOf(number), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(getBaseContext(), MyService.class), serviceConnection, Context.BIND_AUTO_CREATE);
                startService(new Intent(getBaseContext(), MyService.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d("younes", "onDestroy");
        super.onDestroy();
    }
}