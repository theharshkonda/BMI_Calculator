package com.example.bmicalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText weight1,height1;
    TextView t1,t2,Bmi,Category;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_300)));
        weight1=findViewById(R.id.editTextNumberDecimal);
        height1=findViewById(R.id.editTextNumberDecimal2);
        Bmi=findViewById(R.id.textView5);
        Category=findViewById(R.id.textView6);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strweight=weight1.getText().toString();
                String strheight=height1.getText().toString();
                if (strweight.equals("")){
                    weight1.setError("Enter your weight");
                    weight1.requestFocus();
                    return;
                }
                if(strheight.equals("")){
                    height1.setError("Enter your height");
                    height1.requestFocus();
                    return ;
                }
                float weight=Float.parseFloat(strweight);
                float height=Float.parseFloat(strheight)/100;
                float bmiValue=BMICalculate(weight,height);
                Bmi.setText(interpretBMI(bmiValue));
                Category.setText("BMI :"+bmiValue);
            }
            public float BMICalculate(float weight,float height){
                return weight/(height*height);
            }
            public String interpretBMI(float bmiValue){

                if (bmiValue<15.0){
                    return "Very Severely underweight";
                }
                if (bmiValue<16){
                    return "Severely underweight";
                }
                if (bmiValue<18.5){
                    return "underweight";
                }
                if (bmiValue<25){
                    return "Normal";
                }
                if (bmiValue<30){
                    return "Overweight";
                }
                if (bmiValue<35){
                    return "Obese Class I";
                }
                if (bmiValue<40){
                    return "Obese Class II";
                }
                if (bmiValue<45){
                    return "Obese Class III";
                }
                else
                    return "Obese";
            }
        });

    }


}