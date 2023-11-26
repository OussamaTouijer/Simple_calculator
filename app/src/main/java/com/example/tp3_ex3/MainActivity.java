package com.example.tp3_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        TextView number1= (TextView) findViewById(R.id.v1);
        TextView number2= (TextView) findViewById(R.id.v2);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gr);
        RadioButton radioButton =(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId()) ;


        if(!number1.getText().toString().isEmpty()&& !number2.getText().toString().isEmpty() && radioButton != null) {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            TextView result = (TextView) findViewById(R.id.res);
            switch (radioButton.getText().toString()) {
                case "plus":
                    result.setText(String.valueOf(num1 + num2));
                    break;
                case  "moins":
                    result.setText(String.valueOf(num1 - num2));
                    break;
                case "multiplie":
                    result.setText(String.valueOf(num1 * num2));
                    break;
                case "divise":
                    if(num2 != 0) {
                        result.setText(String.valueOf(num1 / num2));
                    }else {
                        Context context = getApplicationContext();
                        CharSequence text = "Division by zero is not allowed";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    break;
            }
        }else {
            Context context = getApplicationContext();
            CharSequence text = "Please enter a number or select an operation";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void reset(View v){
        TextView number1= (TextView) findViewById(R.id.v1);
        TextView number2= (TextView) findViewById(R.id.v2);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gr);

        RadioButton radioButton =(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId()) ;
        radioButton.setChecked(false);
        TextView result = (TextView) findViewById(R.id.res);
        number1.setText("");
        number2.setText("");

        result.setText("");
    }

    public void quitter(View v){
        finish();
        System.exit(0);
    }
}