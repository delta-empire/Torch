package ru.sergeipavlov.torch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button btnTorch;
    Button btnCompass;
    Button btnMorse;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        btnTorch = findViewById(R.id.btnTorch);
        btnCompass = findViewById(R.id.btnCompass);
        btnMorse = findViewById(R.id.btnMorse);

        btnTorch.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), TorchActivity.class)));

        btnMorse.setOnClickListener(v -> {

        });

        btnCompass.setOnClickListener(v -> {

        });


    }


}