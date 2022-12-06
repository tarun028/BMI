package com.example.bmiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight , edtHeightFT , edtHeightInch;
        Button btnCalc;
        TextView txtResult;
        LinearLayout llMain;



        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFT = findViewById(R.id.edtHeightFT);
        edtHeightInch = findViewById(R.id.edtHeightInch);
        btnCalc = findViewById(R.id.btnCalc);
        txtResult = findViewById(R.id.txtResult);
        llMain= findViewById(R.id.llMain);



        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt =Integer.parseInt(edtWeight.getText().toString());
                int ft =Integer.parseInt(edtHeightFT.getText().toString());
                int in =Integer.parseInt(edtHeightInch.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm= totalIn*2.53;
                double totalM= totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("OverWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colourOW));
                }
                else if(bmi<18){
                    txtResult.setText("UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colourUW));
                }
                else{
                    txtResult.setText("Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colourH));
                }

            }
        });



    }
}