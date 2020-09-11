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

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtBinary,edtHex,edtOctel,edtDesimal;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn00,btnDot,btnA,btnB,btnC,btnD,btnE,btnF,btnBack,btnSave,btnHistory;
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

        edtBinary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){}
            @Override
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.equals("")){
                    Log.d("tg","edittext not empty");
                }
            }
        });

        edtDesimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){}
            @Override
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.equals("")){
                    Log.d("tg","edittext not empty");
                }
            }
        });

        edtHex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){}
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
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){}
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
        switch(view.getId()) {
            case R.id.btn0:
                Log.d("tg", "btn0");
                break;
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                Log.d("tg", "btn6");
                break;
            case R.id.btn7:
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btn00:
                break;
            case R.id.btnDot:
                break;
            case R.id.btnA:
                Log.d("tg", "btnA");
                break;
            case R.id.btnB:
                break;
            case R.id.btnC:
                break;
            case R.id.btnD:
                break;
            case R.id.btnE:
                break;
            case R.id.btnF:
                break;
            case R.id.btnSave:
                break;
            case R.id.btnBack:
                break;
            case R.id.btnHistory:
                Log.d("tg", "btnHistory");
                break;
        }
    }
}