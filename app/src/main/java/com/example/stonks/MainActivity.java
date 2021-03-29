package com.example.stonks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button calculate;
    private EditText buyValue;
    private EditText stonkAmmount;
    private EditText sellValue;
    private TextView stonkRes;
    private ConstraintLayout mainLayout;

    private ColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate_stonks);
        buyValue = findViewById(R.id.buy_value);
        stonkAmmount = findViewById(R.id.stonk_ammount);
        sellValue = findViewById(R.id.sell_value);
        stonkRes = findViewById(R.id.stonks_res);
        mainLayout = findViewById(R.id.main_layout);

        calculate.setOnClickListener(this);

        colorPicker = findViewById(R.id.colorPicker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                mainLayout.setBackgroundColor(color);
                //mainLayout.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
            }
        });

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculate_stonks:
                try {
                    float buy_value, sell_value, res;
                    float stonks = Float.valueOf(stonkAmmount.getText().toString());
                    float buy = Float.valueOf(buyValue.getText().toString());
                    float sell = Float.valueOf(sellValue.getText().toString());
                    buy_value = buy * stonks;
                    sell_value = sell * stonks;
                    res = sell_value - buy_value;
                    stonkRes.setText("$" + res);
                } catch (Exception e) {
                    Log.d("Error", e.toString());
                    stonkRes.setText(getString(R.string.stonk_empty));
                }
        }
    }
}