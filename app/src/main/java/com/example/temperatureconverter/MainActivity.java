package com.example.temperatureconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private final String[] tempUnit ={"Celsius","Fahrenheit","Kelvin","Rankine","Reaumur"};
    ArrayAdapter<String> myAdapter;
    Spinner spinner_first,spinner_second;
    EditText input_number;
    TextView result;

    String unit1,unit2;

    DecimalFormat df = new DecimalFormat("#.####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_number = findViewById(R.id.et_input);
        result = findViewById(R.id.tv_result);

        spinner_first = findViewById(R.id.spinner_first);
        spinner_second = findViewById(R.id.spinner_second);

        myAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.spinner_layout,tempUnit);

        myAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner_first.setAdapter(myAdapter);
        spinner_second.setAdapter(myAdapter);
        spinner_first.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit1 = tempUnit[position];
                getResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit2 = tempUnit[position];
                getResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        input_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getResult();
            }
        });
    }
    public void getResult(){
        String input = input_number.getText().toString().trim();
        if(input.isEmpty()){
            result.setText("");
            return;
        }
        double number = Double.parseDouble(input);
        double calculate;
        String res;

        switch (unit1) {
            case "Celsius":
                switch (unit2) {
                    case "Celsius":
                        res = input + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate = number * (9 / 5.0) + 32;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = number + 273.15;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        calculate = (number * 9 / 5) + 491.67;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = number * 0.8;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Fahrenheit":
                switch (unit2) {
                    case "Celsius":
                        calculate = (number - 32) * 5 / 9;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        res = input + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = ((number - 32) * 5 / 9) + 273.15;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        calculate = number + 459.67;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = (number - 32) * 4 / 9;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Kelvin":
                switch (unit2) {
                    case "Celsius":
                        calculate = number - 273.15;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate = (number - 273.15) * 9 / 5 + 32;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        res = input + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        calculate = number * 1.8;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = (number - 273.15) * 0.8;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Rankine":
                switch (unit2) {
                    case "Celsius":
                        calculate = (number - 32 - 459.67) / 1.8;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate = number - 459.67;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = number / 1.8;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        res = input + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = (number - 32 - 459.67) / 2.25;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Reaumur":
                switch (unit2) {
                    case "Celsius":
                        calculate = number * 1.25;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate = (number * 2.25) + 32;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = (number * 1.25) + 273.15;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        calculate = (number * 2.25) + 459.67 + 32;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        res = input + " °Re";
                        result.setText(res);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}