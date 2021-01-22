package com.example.project5_penjumlahan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText bil1;
    private EditText bil2;
    private EditText jumlah;
    private Button btnHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }

    private void initUI(){
        bil1 = (EditText)findViewById(R.id.ETX1);
        bil2 = (EditText)findViewById(R.id.ETX2);
        jumlah = (EditText)findViewById(R.id.ETX3);
        btnHasil = (Button)findViewById(R.id.BTNJumlah);
    }

    private void initEvent(){
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungJumlah();
            }
        });
    }

    private void hitungJumlah(){
        int angka1 = Integer.parseInt(bil1.getText().toString());
        int angka2 = Integer.parseInt(bil2.getText().toString());
        int total = angka1 + angka2;
        jumlah.setText(total);
    }
}