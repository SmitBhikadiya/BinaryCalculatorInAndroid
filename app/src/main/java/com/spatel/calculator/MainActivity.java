package com.spatel.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd,btnSub,btnMul,btnDiv;
    private EditText edtNum1,edtNum2;
    private TextView txtResult;
    private Spinner spFirst,spSecond;
    private Converter converter;
    private String sumD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        txtResult = findViewById(R.id.txtResult);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);

        spFirst = findViewById(R.id.spFirst);
        spSecond = findViewById(R.id.spSecond);

        converter = new Converter();

        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String num1 = edtNum1.getText().toString().toUpperCase();
        String num2 = edtNum2.getText().toString().toUpperCase();
        String sp1 = spFirst.getSelectedItem().toString();
        String sp2 = spSecond.getSelectedItem().toString();
        if(!num1.equals("") || !num2.equals("")){
            switch (view.getId()){
                case R.id.btnAdd:
                    sumD = getResult(num1,num2,sp1,sp2,"Add");
                    break;
                case R.id.btnSub:
                    sumD = getResult(num1,num2,sp1,sp2,"Sub");
                    break;
                case R.id.btnDiv:
                    sumD = getResult(num1,num2,sp1,sp2,"Div");
                    break;
                case R.id.btnMul:
                    sumD = getResult(num1,num2,sp1,sp2,"Mul");
                    break;
            }
            sumD = "---Desimal---\n" + sumD +
                    "\n\n---Binary---\n" + converter.desimalToBinary(sumD)+
                    "\n\n---Octel---\n" + converter.desimalToOctel(sumD)+
                    "\n\n---Hexa Desimal---\n" + converter.desimalToHexa(sumD);
            txtResult.setText(sumD.toUpperCase());
        }
        else{
            Toast.makeText(this,"Enter value first",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private String getResult(String n1,String n2,String sp1,String sp2,String str) {
        String result;
        switch (sp1){
            case "OCT":
                n1 = converter.octelToDesimal(n1);
                break;
            case "HEX":
                n1 = converter.hexaToDesimal(n1);
                break;
            case "BIN":
                n1 = converter.binaryToDesimal(n1);
                break;
        }
        switch (sp2){
            case "OCT":
                n2 = converter.octelToDesimal(n2);
                break;
            case "HEX":
                n2 = converter.hexaToDesimal(n2);
                break;
            case "BIN":
                n2 = converter.binaryToDesimal(n2);
                break;
        }
        BigInteger b1 = new BigInteger(n1);
        if(str.equals("Add")){
            result = b1.add(new BigInteger(n2)).toString();
        }
        else if(str.equals("Sub")){
            result = b1.subtract(new BigInteger(n2)).toString();
        }
        else if(str.equals("Div")){
            try{
                result = b1.divide(new BigInteger(n2)).toString();
            }
            catch (Exception e){
                return "";
            }
        }
        else{
            result = b1.multiply(new BigInteger(n2)).toString();
        }
        return result;
    }
}