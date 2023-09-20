package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText integer1 = (EditText) findViewById(R.id.integer1);
        EditText integer2 = (EditText) findViewById(R.id.integer2);
        double input1 = Double.parseDouble(integer1.getText().toString());
        double input2 = Double.parseDouble(integer2.getText().toString());
        String result = "";
        if (view.getId() == R.id.plusButton){
            result = Double.toString(input1 + input2);
        } else if (view.getId() == R.id.minusButton) {
            result = Double.toString(input1 - input2);
        } else if (view.getId() == R.id.multiplyButton) {
            result = Double.toString(input1 * input2);
        } else if (view.getId() == R.id.divideButton) {
            if (input2 == 0) {
                result = "Error: Divide by Zero";
            }
            else {
                result = Double.toString(input1 / input2);
            }
        }
        goToActivity(result);
    }
    public void goToActivity(String s) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}