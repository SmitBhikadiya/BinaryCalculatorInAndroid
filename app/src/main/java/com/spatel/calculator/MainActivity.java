package com.spatel.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd,btnSub,btnMul,btnDiv;
    private EditText edtNum1,edtNum2;
    private TextView txtResultBin,txtResultHex,txtResultOct,txtResultDes;
    private Spinner spinner;
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

        txtResultBin = findViewById(R.id.txtResultBin);
        txtResultDes = findViewById(R.id.txtResultDes);
        txtResultOct = findViewById(R.id.txtResultOct);
        txtResultHex = findViewById(R.id.txtResultHex);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);

        spinner = findViewById(R.id.spFirst);

        converter = new Converter();

        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String fstr = spinner.getSelectedItem().toString();
                setDigitAccordingToSpinner(fstr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                setDigitAccordingToSpinner("DES");
            }
        });
    }

    private void setDigitAccordingToSpinner(String sp1) {
        switch (sp1){
            case "OCT":
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456"));
                break;
            case "HEX":
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setInputType(InputType.TYPE_CLASS_TEXT);
                edtNum2.setInputType(InputType.TYPE_CLASS_TEXT);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEF"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEF"));
                break;
            case "BIN":
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("01"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("01"));
                break;
            case "DES":
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        String num1 = edtNum1.getText().toString().toUpperCase();
        String num2 = edtNum2.getText().toString().toUpperCase();
        String sp1 = spinner.getSelectedItem().toString();
        if(!num1.equals("") && !num2.equals("")){
            switch (view.getId()){
                case R.id.btnAdd:
                    sumD = getResult(num1,num2,sp1,"Add");
                    break;
                case R.id.btnSub:
                    sumD = getResult(num1,num2,sp1,"Sub");
                    break;
                case R.id.btnDiv:
                    sumD = getResult(num1,num2,sp1,"Div");
                    break;
                case R.id.btnMul:
                    sumD = getResult(num1,num2,sp1,"Mul");
                    break;
            }
            try{
                txtResultBin.setText("Binary\n"+converter.desimalToBinary(sumD));
                txtResultDes.setText("Desimal\n"+sumD.toUpperCase());
                txtResultOct.setText("Octel\n"+converter.desimalToOctel(sumD));
                txtResultHex.setText("HexaDesimal\n"+converter.desimalToHexa(sumD).toUpperCase());
            }catch (NumberFormatException e){
                Toast.makeText(this,"Too large number not allowed",Toast.LENGTH_SHORT).show();
                return;
            }
            setBackgroundOnText(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorWhite));
        }
        else{
            Toast.makeText(this,"Enter a number first",Toast.LENGTH_SHORT).show();
            setBackgroundOnText(getResources().getColor(R.color.colorDark),getResources().getColor(R.color.colorDark));
            return;
        }
    }

    private void setBackgroundOnText(int color, int color1) {
        txtResultBin.setBackgroundColor(color);
        txtResultBin.setTextColor(color1);
        txtResultDes.setBackgroundColor(color);
        txtResultDes.setTextColor(color1);
        txtResultHex.setBackgroundColor(color);
        txtResultHex.setTextColor(color1);
        txtResultOct.setBackgroundColor(color);
        txtResultOct.setTextColor(color1);
    }


    private String getResult(String n1,String n2,String sp1,String str) {
        String result;
        try{
            switch (sp1){
                case "OCT":
                    n1 = converter.octelToDesimal(n1);
                    n2 = converter.octelToDesimal(n2);
                    break;
                case "HEX":
                    n1 = converter.hexaToDesimal(n1);
                    n2 = converter.hexaToDesimal(n2);
                    break;
                case "BIN":
                    n1 = converter.binaryToDesimal(n1);
                    n2 = converter.binaryToDesimal(n2);
                    break;
            }
        }
        catch (Exception e){
            return "";
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