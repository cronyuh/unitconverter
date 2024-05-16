package com.example.unitconverter;

import android.annotation.SuppressLint;
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

public class CelciusToKelvin extends AppCompatActivity {

    EditText temptext;
    Button  temp_converter;
    TextView temp_result;
    ImageView length, kg,pound;
    Editable input;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_celcius_to_kelvin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        temptext = findViewById(R.id.temptext);
        temp_converter = findViewById(R.id.temp_converter);
        temp_result = findViewById(R.id.temp_result);
        pound = findViewById(R.id.pound);
        kg =findViewById(R.id.kg);
        length =findViewById(R.id.length);

        temp_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String tempString = temptext.getText().toString();
                if (!tempString.isEmpty()) {
                    // Chuyển đổi giá trị từ string sang số double
                    double celsiusValue = Double.parseDouble(tempString);
                    // Chuyển đổi từ Celsius sang Kelvin (K = C + 273.15)
                    double kelvinValue = celsiusValue + 273.15;
                    // Hiển thị kết quả trên TextView
                    temp_result.setText(String.format("%.2f K", kelvinValue));

                    Toast.makeText(getApplicationContext(), String.format("%.2f K", kelvinValue), Toast.LENGTH_SHORT).show();

                } else {
                    // Nếu EditText trống, thông báo nhập giá trị
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập giá trị độ Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });


        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CelciusToKelvin.this,KgToPound.class);
                startActivity(intent);
            }
        });

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CelciusToKelvin.this,KgToGram.class);
                startActivity(intent);
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CelciusToKelvin.this,MetertoFeet.class);
                startActivity(intent);
            }
        });
    }
}