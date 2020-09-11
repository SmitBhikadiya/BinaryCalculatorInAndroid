package com.spatel.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener {
    private EditText edtBinary,edtHex,edtOctel,edtDesimal;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn00,btnDot,btnA,btnB,btnC,btnD,btnE,btnF,btnBack,btnSave,btnHistory;
    private EditText isHoverAndGetId;
    private LinearLayout llKeypad;
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
        btn00 = findViewById(R.id.btn00);
        btnDot = findViewById(R.id.btnDot);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        btnSave = findViewById(R.id.btnSave);
        btnHistory = findViewById(R.id.btnHistory);
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
        btn00.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        edtBinary.setOnFocusChangeListener(this);
        edtOctel.setOnFocusChangeListener(this);
        edtHex.setOnFocusChangeListener(this);
        edtDesimal.setOnFocusChangeListener(this);

        edtBinary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.equals("")){
                    Log.d("tg","edittext not empty");
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
                if(!charSequence.equals("")) {

                }
            }
        });

        edtHex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.equals("")){
                    Log.d("tg","edittext not empty");
                }
            }
        });

        edtOctel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){ }
            @Override
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.equals("")){
                    Log.d("tg","edittext not empty");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        String text = isHoverAndGetId.getText().toString().trim();
        switch(view.getId()) {
            case R.id.btn0:
                isHoverAndGetId.setText(text+"0");
                Log.d("tg", "btn0");
                break;
            case R.id.btn1:
                isHoverAndGetId.setText(text+"1");
                break;
            case R.id.btn2:
                isHoverAndGetId.setText(text+"2");
                break;
            case R.id.btn3:
                isHoverAndGetId.setText(text+"3");
                break;
            case R.id.btn4:
                isHoverAndGetId.setText(text+"4");
                break;
            case R.id.btn5:
                isHoverAndGetId.setText(text+"5");
                break;
            case R.id.btn6:
                isHoverAndGetId.setText(text+"6");
                Log.d("tg", "btn6");
                break;
            case R.id.btn7:
                isHoverAndGetId.setText(text+"7");
                break;
            case R.id.btn8:
                isHoverAndGetId.setText(text+"8");
                break;
            case R.id.btn9:
                isHoverAndGetId.setText(text+"9");
                break;
            case R.id.btn00:
                isHoverAndGetId.setText(text+"00");
                break;
            case R.id.btnDot:
                isHoverAndGetId.setText(text+".");
                break;
            case R.id.btnA:
                isHoverAndGetId.setText(text+"A");
                Log.d("tg", "btnA");
                break;
            case R.id.btnB:
                isHoverAndGetId.setText(text+"B");
                break;
            case R.id.btnC:
                isHoverAndGetId.setText(text+"C");
                break;
            case R.id.btnD:
                isHoverAndGetId.setText(text+"D");
                break;
            case R.id.btnE:
                isHoverAndGetId.setText(text+"E");
                break;
            case R.id.btnF:
                isHoverAndGetId.setText(text+"F");
                break;
            case R.id.btnSave:
                break;
            case R.id.btnBack:
                String s = text.substring(0,text.length()-2);
                isHoverAndGetId.setText(s);
                break;
            case R.id.btnHistory:
                Log.d("tg", "btnHistory");
                break;
        }
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