package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KgToGram extends AppCompatActivity {

    EditText kgtext;
    Button  kg_converter;
    TextView kg_result;
    ImageView length, temp,pound;
    Editable input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kg_to_gram);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        kgtext = findViewById(R.id.kgtext);
        kg_converter = findViewById(R.id.kg_converter);
        kg_result = findViewById(R.id.kg_result);
        pound = findViewById(R.id.pound);
        temp =findViewById(R.id.temp);
        length =findViewById(R.id.length);



        kg_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String kgString = kgtext.getText().toString();
                if (!kgString.isEmpty()) {
                    // Chuyển đổi giá trị từ string sang số double
                    double kgValue = Double.parseDouble(kgString);
                    // Chuyển đổi từ kilogram sang gram (1 kg = 1000 gram)
                    double gramValue = kgValue * 1000;
                    // Hiển thị kết quả trên TextView
                    kg_result.setText(String.format("%.0f gram", gramValue));
                    Toast.makeText(getApplicationContext(), String.format("%.0f gram", gramValue), Toast.LENGTH_SHORT).show();

                } else {
                    // Nếu EditText trống, thông báo nhập giá trị
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập giá trị kilogram", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToGram.this,KgToPound.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToGram.this,CelciusToKelvin.class);
                startActivity(intent);
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToGram.this,MetertoFeet.class);
                startActivity(intent);
            }
        });
    }
}