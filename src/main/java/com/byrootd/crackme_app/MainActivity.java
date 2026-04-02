package com.byrootd.crackme_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText etKey = findViewById(R.id.et_key);
        Button btnUnlock = findViewById(R.id.btn_unlock);
        TextView tvStatus = findViewById(R.id.tv_status);

        btnUnlock.setOnClickListener(v -> {
            String input = etKey.getText().toString();


            int result = NativeGate.verifyAccess(input);

            if (result == 1) {

                tvStatus.setText("System: Access Granted!");
                tvStatus.setTextColor(android.graphics.Color.GREEN);

                Toast.makeText(this, "Doğrulama Başarılı!", Toast.LENGTH_SHORT).show();

                // 2. Sayfaya (Loading) geçiş yap
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
            } else {

                tvStatus.setText("System: Access Denied!");
                tvStatus.setTextColor(android.graphics.Color.RED);

                Toast.makeText(this, "Hatalı Anahtar!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}