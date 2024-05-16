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

public class KgToPound extends AppCompatActivity {

    EditText poundtext;
    Button  pound_converter;
    TextView pound_result;
    ImageView length, temp,kg;
    Editable input;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kg_to_pound);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        poundtext = findViewById(R.id.poundtext);
        pound_converter = findViewById(R.id.pound_converter);
        pound_result = findViewById(R.id.pound_result);
        kg = findViewById(R.id.kg);
        temp =findViewById(R.id.temp);
        length =findViewById(R.id.length);


        pound_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String poundString = poundtext.getText().toString();
                if (!poundString.isEmpty()) {
                    // Chuyển đổi giá trị từ string sang số double
                    double kgValue = Double.parseDouble(poundString);
                    // Chuyển đổi từ kilogram sang pound (1 kg = 2.20462 pound)
                    double poundValue = kgValue * 2.20462;
                    // Hiển thị kết quả trên TextView
                    pound_result.setText(String.format("%.2f pounds", poundValue));
                    Toast.makeText(getApplicationContext(), String.format("%.2f pounds", poundValue), Toast.LENGTH_SHORT).show();

                } else {
                    // Nếu EditText trống, thông báo nhập giá trị
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập giá trị kilogram", Toast.LENGTH_SHORT).show();
                }
            }
        });



        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToPound.this,KgToGram.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToPound.this,CelciusToKelvin.class);
                startActivity(intent);
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KgToPound.this,MetertoFeet.class);
                startActivity(intent);
            }
        });
    }
}