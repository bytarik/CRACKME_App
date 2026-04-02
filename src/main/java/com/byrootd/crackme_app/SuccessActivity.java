package com.byrootd.crackme_app;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button btnExit = findViewById(R.id.btn_exit);

        // Çıkış butonuna basınca uygulamayı kapatır
        btnExit.setOnClickListener(v -> {
            finishAffinity(); // Tüm aktiviteleri kapat
            System.exit(0);
        });
    }
}
