package com.spatel.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener {
    private EditText edtBinary,edtHex,edtOctel,edtDesimal;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnA,btnB,btnC,btnD,btnE,btnF,btnBack,btnSave,btnHistory;
    private EditText isHoverAndGetId;
    private Converter converter;
    private String desimal,binary,hexa,octel;
    private Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // get refrence in order to access it
        edtBinary = findViewById(R.id.edtBinary);
        edtDesimal = findViewById(R.id.edtDesimal);
        edtHex = findViewById(R.id.edtHex);
        edtOctel = findViewById(R.id.edtOctel);

        // button key refrencce
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        btnBack = findViewById(R.id.btnBack);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        edtBinary.setOnFocusChangeListener(this);
        edtOctel.setOnFocusChangeListener(this);
        edtHex.setOnFocusChangeListener(this);
        edtDesimal.setOnFocusChangeListener(this);

        // create Instance of a object
        converter = new Converter();

        //Intialization
        isHoverAndGetId = edtBinary;

        edtBinary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(flag.equals(true)){
                    flag = false;
                    binary = edtBinary.getText().toString().trim();
                    desimal = converter.binaryToDesimal(binary);
                    octel = converter.desimalToOctel(desimal);
                    hexa = converter.desimalToHexa(desimal);
                    setTextOnEdittext(desimal,binary,octel,hexa);
                }
            }
        });

        edtDesimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(flag.equals(true)){
                    flag = false;
                    desimal = edtDesimal.getText().toString().trim();
                    binary = converter.desimalToBinary(desimal);
                    octel = converter.desimalToOctel(desimal);
                    hexa = converter.desimalToHexa(desimal);
                    setTextOnEdittext(desimal,binary,octel,hexa);
                }
            }
        });

        edtHex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(flag.equals(true)){
                    flag = false;
                    hexa = edtHex.getText().toString().trim();
                    desimal = converter.hexaToDesimal(hexa);
                    octel = converter.desimalToOctel(desimal);
                    binary = converter.desimalToBinary(desimal);
                    setTextOnEdittext(desimal,binary,octel,hexa);
                }
            }
        });

        edtOctel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(flag.equals(true)){
                    flag = false;
                    octel = edtOctel.getText().toString().trim();
                    desimal = converter.octelToDesimal(octel);
                    binary = converter.desimalToBinary(desimal);
                    hexa = converter.desimalToHexa(desimal);
                    setTextOnEdittext(desimal,binary,octel,hexa);
                }
            }
        });
    }

    private void setTextOnEdittext(String desimal, String binary, String octel, String hexa) {
        edtDesimal.setText(desimal);
        edtHex.setText(hexa);
        edtOctel.setText(octel);
        edtBinary.setText(binary);
        isHoverAndGetId.setSelection(isHoverAndGetId.getText().length());
        flag = true;
    }

    @Override
    public void onClick(View view) {
        String text = isHoverAndGetId.getText().toString().trim();
        if(text.isEmpty()){
            text = "";
        }
        int id = view.getId();
        String value = "";
        switch(id) {
            case R.id.btn0:
                value = "0";
                break;
            case R.id.btn1:
                value = "1";
                break;
            case R.id.btn2:
                value = "2";
                break;
            case R.id.btn3:
                value = "3";
                break;
            case R.id.btn4:
                value = "4";
                break;
            case R.id.btn5:
                value = "5";
                break;
            case R.id.btn6:
                value = "6";
                break;
            case R.id.btn7:
                value = "7";
                break;
            case R.id.btn8:
                value = "8";
                break;
            case R.id.btn9:
                value = "9";
                break;
            case R.id.btnA:
                value = "A";
                break;
            case R.id.btnB:
                value = "B";
                break;
            case R.id.btnC:
                value = "C";
                break;
            case R.id.btnD:
                value = "D";
                break;
            case R.id.btnE:
                value = "E";
                break;
            case R.id.btnF:
                value = "F";
                break;
            case R.id.btnBack:
                if(!text.equals("")){
                    text = text.substring(0,text.length()-1);
                    value = "";
                    isHoverAndGetId.setText(text);
                }
                break;
        }
        isHoverAndGetId.append(value);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.edtBinary:
                isHoverAndGetId = edtBinary;
                Log.d("tg", "edtBinary");
                break;
            case R.id.edtDesimal:
                isHoverAndGetId = edtDesimal;
                Log.d("tg", "edtDesimal");
                break;
            case R.id.edtOctel:
                isHoverAndGetId = edtOctel;
                Log.d("tg", "edtOctel");
                break;
            case R.id.edtHex:
                isHoverAndGetId = edtHex;
                Log.d("tg", "edtHex");
                break;
        }
    }
}