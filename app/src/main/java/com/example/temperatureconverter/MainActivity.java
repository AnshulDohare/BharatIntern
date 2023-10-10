package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private final String[] tempUnit ={"Select Unit","Celsius","Fahrenheit","Kelvin","Rankine","Reaumur"};
    ArrayAdapter<String> myAdapter;
    Spinner spinner_first,spinner_second;
    EditText input_number;
    TextView result;
    Button convert;

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

        convert = findViewById(R.id.btn_convert);
        myAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.spinner_layout,tempUnit);

        myAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner_first.setAdapter(myAdapter);
        spinner_second.setAdapter(myAdapter);
        spinner_first.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit1 = tempUnit[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit2 = tempUnit[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(v->{
            String input = input_number.getText().toString().trim();
            if(input.isEmpty()){
                Toast.makeText(this, "Enter Temperature", Toast.LENGTH_SHORT).show();
                return;
            }
            double number = Double.parseDouble(input);
            double calculate;
            String res;
            if(unit1.equals("Select Unit")&&unit2.equals("Select Unit")){
                Toast.makeText(this, "Select Units", Toast.LENGTH_SHORT).show();
            }
            else if(unit1.equals("Select Unit")){
                Toast.makeText(this, "Select The Unit From Which You Want to Convert", Toast.LENGTH_SHORT).show();
            }
            else if(unit1.equals("Celsius")){
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
                    case "Select Unit":
                        Toast.makeText(this, "Select The Unit In Which You Want to Convert", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
            }
            else if (unit1.equals("Fahrenheit")) {
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
                        calculate = number+459.67;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = (number-32)*4/9;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    case "Select Unit":
                        Toast.makeText(this, "Select The Unit In Which You Want to Convert", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
            }
            else if(unit1.equals("Kelvin")){
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
                        calculate = number*1.8;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate = (number - 273.15) * 0.8;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    case "Select Unit":
                        Toast.makeText(this, "Select The Unit In Which You Want to Convert", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
            }
            else if (unit1.equals("Rankine")){
                switch (unit2) {
                    case "Celsius":
                        calculate = ( number - 32 - 459.67) / 1.8;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate =  number - 459.67;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = number/1.8;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        res = input + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        calculate =( number - 32 - 459.67) / 2.25;
                        res = df.format(calculate) + " °Re";
                        result.setText(res);
                        break;
                    case "Select Unit":
                        Toast.makeText(this, "Select The Unit In Which You Want to Convert", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
            }
            else if (unit1.equals("Reaumur")) {
                switch (unit2) {
                    case "Celsius":
                        calculate = number * 1.25;
                        res = df.format(calculate) + " °C";
                        result.setText(res);
                        break;
                    case "Fahrenheit":
                        calculate =  (number * 2.25 )+ 32;
                        res = df.format(calculate) + " °F";
                        result.setText(res);
                        break;
                    case "Kelvin":
                        calculate = (number * 1.25) + 273.15;
                        res = df.format(calculate) + " K";
                        result.setText(res);
                        break;
                    case "Rankine":
                        calculate = (number*  2.25) +459.67+32;
                        res = df.format(calculate) + " °R";
                        result.setText(res);
                        break;
                    case "Reaumur":
                        res = input + " °Re";
                        result.setText(res);
                        break;
                    case "Select Unit":
                        Toast.makeText(this, "Select The Unit In Which You Want to Convert", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Something went wrong, Try Again...", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }
}