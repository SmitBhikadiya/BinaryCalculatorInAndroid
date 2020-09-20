package com.spatel.calculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private Button btnAdd, btnSub, btnMul, btnDiv, btnPaste1, btnPaste2, btnClear,btnA,btnB,btnC,btnD,btnE,btnF;
    private EditText edtNum1, edtNum2, edtSelect;
    private TextView txtResultBin, txtResultHex, txtResultOct, txtResultDes;
    private Spinner spinner;
    private Converter converter;
    private String sumD = "";
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnPaste1 = findViewById(R.id.btnPaste1);
        btnPaste2 = findViewById(R.id.btnPaste2);
        btnClear = findViewById(R.id.btnClear);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);

        ll = findViewById(R.id.hexaDigits);

        txtResultBin = findViewById(R.id.txtResultBin);
        txtResultDes = findViewById(R.id.txtResultDes);
        txtResultOct = findViewById(R.id.txtResultOct);
        txtResultHex = findViewById(R.id.txtResultHex);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);

        spinner = findViewById(R.id.spFirst);

        converter = new Converter();

        edtNum2.setOnFocusChangeListener(this);
        edtNum1.setOnFocusChangeListener(this);
        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnPaste1.setOnClickListener(this);
        btnPaste2.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);


        edtSelect = edtNum1;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String fstr = spinner.getSelectedItem().toString();
                setDigitAccordingToSpinner(fstr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //setDigitAccordingToSpinner("BIN");
            }
        });
    }

    private void setDigitAccordingToSpinner(String sp1) {
        switch (sp1) {
            case "Octel":
                ll.setVisibility(View.GONE);
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456"));
                break;
            case "HexaDesimal":
                ll.setVisibility(View.VISIBLE);
                edtNum1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                edtNum2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEF"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEF"));
                break;
            case "Binary":
                ll.setVisibility(View.GONE);
                edtNum1.setMaxLines(3);
                edtNum2.setMaxLines(3);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("01"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("01"));
                break;
            case "Desimal":
                ll.setVisibility(View.GONE);
                edtNum1.setMaxLines(1);
                edtNum2.setMaxLines(1);
                edtNum1.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                edtNum2.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPaste1:
                pasteValue(edtNum1);
                edtNum1.setSelection(edtNum1.getText().length());
                break;
            case R.id.btnPaste2:
                pasteValue(edtNum2);
                edtNum2.setSelection(edtNum2.getText().length());
                break;
            case R.id.btnClear:
                edtSelect.setText("");
                break;
            case R.id.btnA:
                edtSelect.setText(edtSelect.getText().toString()+"A");
                break;
            case R.id.btnB:
                edtSelect.setText(edtSelect.getText().toString()+"B");
                break;
            case R.id.btnC:
                edtSelect.setText(edtSelect.getText().toString()+"C");
                break;
            case R.id.btnD:
                edtSelect.setText(edtSelect.getText().toString()+"D");
                break;
            case R.id.btnE:
                edtSelect.setText(edtSelect.getText().toString()+"E");
                break;
            case R.id.btnF:
                edtSelect.setText(edtSelect.getText().toString()+"F");
                break;
        }
        edtSelect.setSelection(edtSelect.getText().length());
        String num1 = edtNum1.getText().toString().toUpperCase();
        String num2 = edtNum2.getText().toString().toUpperCase();
        String sp1 = spinner.getSelectedItem().toString();
        if (!num1.equals("") && !num2.equals("")) {
            switch (view.getId()) {
                case R.id.btnAdd:
                    sumD = getResult(num1, num2, sp1, "Add");
                    break;
                case R.id.btnSub:
                    sumD = getResult(num1, num2, sp1, "Sub");
                    break;
                case R.id.btnDiv:
                    sumD = getResult(num1, num2, sp1, "Div");
                    break;
                case R.id.btnMul:
                    sumD = getResult(num1, num2, sp1, "Mul");
                    break;
            }
            try {
                txtResultBin.setText("Binary\n" + converter.desimalToBinary(sumD));
                txtResultDes.setText("Desimal\n" + sumD);
                txtResultOct.setText("Octel\n" + converter.desimalToOctel(sumD));
                txtResultHex.setText("HexaDesimal\n" + converter.desimalToHexa(sumD).toUpperCase());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Too large number is not allowed", Toast.LENGTH_SHORT).show();
                return;
            }
            setBackgroundOnText(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorWhite));
        } else {
            Toast.makeText(this, "Empty field not accepted", Toast.LENGTH_SHORT).show();
            setBackgroundOnText(getResources().getColor(R.color.colorDark), getResources().getColor(R.color.colorDark));
            return;
        }
    }

    private void pasteValue(EditText e) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        ClipData.Item item = clip.getItemAt(0);
        e.setText(item.getText().toString());
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


    private String getResult(String n1, String n2, String sp1, String str) {
        String result;
        switch (sp1) {
            case "Octel":
                n1 = converter.octelToDesimal(n1);
                n2 = converter.octelToDesimal(n2);
                break;
            case "HexaDesimal":
                n1 = converter.hexaToDesimal(n1);
                n2 = converter.hexaToDesimal(n2);
                break;
            case "Binary":
                n1 = converter.binaryToDesimal(n1);
                n2 = converter.binaryToDesimal(n2);
                break;
        }

        if (n1.equals("") || n2.equals("")) {
            if (n1.equals("")) n1 = "0";
            else n2 = "0";
            Toast.makeText(this,"Invalid Number",Toast.LENGTH_SHORT).show();
            return "0";
        }

        BigInteger b1 = new BigInteger(n1);
        if (str.equals("Add")) {
            result = b1.add(new BigInteger(n2)).toString();
        } else if (str.equals("Sub")) {
            result = b1.subtract(new BigInteger(n2)).toString();
        } else if (str.equals("Div")) {
            try {
                result = b1.divide(new BigInteger(n2)).toString();
            } catch (Exception e) {
                return "";
            }
        } else {
            result = b1.multiply(new BigInteger(n2)).toString();
        }
        return result;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.edtNum1:
                edtSelect = edtNum1;
                break;
            case R.id.edtNum2:
                edtSelect = edtNum2;
                break;
        }
    }
}