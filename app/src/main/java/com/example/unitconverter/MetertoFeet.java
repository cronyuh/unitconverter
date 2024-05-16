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

public class MetertoFeet extends AppCompatActivity {

    EditText metertext;
    Button  meter_converter;
    TextView meter_result;
    ImageView temp, kg,pound;
    Editable input;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meterto_feet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        metertext = findViewById(R.id.metertext);
        meter_converter = findViewById(R.id.meter_converter);
        meter_result = findViewById(R.id.meter_result);
        pound = findViewById(R.id.pound);
        kg =findViewById(R.id.kg);
        temp =findViewById(R.id.temp);

        meter_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String meterString = metertext.getText().toString();
                if (!meterString.isEmpty()) {
                    // Chuyển đổi giá trị từ string sang số double
                    double meterValue = Double.parseDouble(meterString);
                    // Chuyển đổi từ mét sang feet (1 mét = 3.28084 feet)
                    double feetValue = meterValue * 3.28084;
                    // Hiển thị kết quả trên TextView
                    meter_result.setText(String.format("%.2f feet", feetValue));
                    Toast.makeText(getApplicationContext(), String.format("%.2f feet", feetValue), Toast.LENGTH_SHORT).show();

                } else {
                    // Nếu EditText trống, thông báo nhập giá trị
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập giá trị mét", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetertoFeet.this,KgToPound.class);
                startActivity(intent);
            }
        });

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetertoFeet.this,KgToGram.class);
                startActivity(intent);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetertoFeet.this,CelciusToKelvin.class);
                startActivity(intent);
            }
        });
    }
}