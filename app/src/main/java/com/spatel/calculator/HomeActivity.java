package com.spatel.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener {

    private EditText edtBinary,edtHex,edtOctel,edtDesimal;
    private LinearLayout layout;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnA,btnB,btnC,btnD,btnE,btnF,btnDel,btnAc,btnCb,btnCo,btnCd,btnCh,btnSave,btnHistory;
    private EditText isHoverAndGetId;
    private Converter converter;
    private TextView txtb,txtd,txto,txth,hoverTeextId;
    private String desimal,binary,hexa,octel;
    private Boolean flag = true;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
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
        layout  = findViewById(R.id.llMe);
        btnDel = findViewById(R.id.btnDel);
        btnAc = findViewById(R.id.btnAc);
        //btnSave = findViewById(R.id.btnSave);
        //btnHistory = findViewById(R.id.btnHistory);
        btnCb = findViewById(R.id.btnCb);
        btnCd = findViewById(R.id.btnCd);
        btnCh = findViewById(R.id.btnCh);
        btnCo = findViewById(R.id.btnCo);

        // texrt view refrence
        txtb = findViewById(R.id.txtBin);
        txtd = findViewById(R.id.txtDes);
        txth = findViewById(R.id.txtHex);
        txto = findViewById(R.id.txtOct);

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
        btnDel.setOnClickListener(this);
        btnAc.setOnClickListener(this);
        //btnSave.setOnClickListener(this);
        //btnHistory.setOnClickListener(this);
        btnCo.setOnClickListener(this);
        btnCh.setOnClickListener(this);
        btnCd.setOnClickListener(this);
        btnCb.setOnClickListener(this);
        edtBinary.setOnClickListener(this);
        edtDesimal.setOnClickListener(this);
        edtHex.setOnClickListener(this);
        edtOctel.setOnClickListener(this);
        edtBinary.setOnFocusChangeListener(this);
        edtOctel.setOnFocusChangeListener(this);
        edtHex.setOnFocusChangeListener(this);
        edtDesimal.setOnFocusChangeListener(this);

        // Shared prefrences
        preferences = getSharedPreferences("Data1",MODE_PRIVATE);
        editor = preferences.edit();

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
                    binary = edtBinary.getText().toString().trim();
                    if(binary.length() > 63){
                        edtBinary.setError("You reached maximum lenght");
                        edtOctel.setEnabled(false);
                        edtHex.setEnabled(false);
                        edtDesimal.setEnabled(false);
                    }
                    else {
                        flag = false;
                        edtBinary.setError(null);
                        edtOctel.setEnabled(true);
                        edtHex.setEnabled(true);
                        edtDesimal.setEnabled(true);
                        desimal = converter.binaryToDesimal(binary);
                        octel = converter.desimalToOctel(desimal);
                        hexa = converter.desimalToHexa(desimal);
                        setTextOnEdittext(desimal, binary, octel, hexa);
                    }
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
                    desimal = edtDesimal.getText().toString().trim();
                    if(desimal.length() > 19){
                        edtDesimal.setError("You reached maximum lenght");
                        edtOctel.setEnabled(false);
                        edtHex.setEnabled(false);
                        edtBinary.setEnabled(false);
                    }
                    else {
                        flag = false;
                        edtDesimal.setError(null);
                        edtOctel.setEnabled(true);
                        edtBinary.setEnabled(true);
                        edtHex.setEnabled(true);
                        binary = converter.desimalToBinary(desimal);
                        octel = converter.desimalToOctel(desimal);
                        hexa = converter.desimalToHexa(desimal);
                        setTextOnEdittext(desimal,binary,octel,hexa);
                    }
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
                    hexa = edtHex.getText().toString().trim();
                    if(hexa.length() > 15){
                        edtHex.setError("You reached maximum lenght");
                        edtOctel.setEnabled(false);
                        edtDesimal.setEnabled(false);
                        edtBinary.setEnabled(false);
                    }
                    else {
                        flag = false;
                        edtHex.setError(null);
                        edtOctel.setEnabled(true);
                        edtBinary.setEnabled(true);
                        edtDesimal.setEnabled(true);
                        desimal = converter.hexaToDesimal(hexa);
                        binary = converter.desimalToBinary(desimal);
                        octel = converter.desimalToOctel(desimal);
                        setTextOnEdittext(desimal, binary, octel, hexa);
                    }
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
                    octel = edtOctel.getText().toString().trim();
                    if(octel.length() > 21){
                        edtOctel.setError("You reached maximum lenght");
                        edtBinary.setEnabled(false);
                        edtHex.setEnabled(false);
                        edtDesimal.setEnabled(false);
                    }
                    else {
                        flag = false;
                        edtOctel.setError(null);
                        edtBinary.setEnabled(true);
                        edtHex.setEnabled(true);
                        edtDesimal.setEnabled(true);
                        desimal = converter.octelToDesimal(octel);
                        binary = converter.desimalToBinary(desimal);
                        hexa = converter.desimalToHexa(desimal);
                        setTextOnEdittext(desimal, binary, octel, hexa);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.history:
                Toast.makeText(this,"history",Toast.LENGTH_SHORT).show();
                break;
            case R.id.darkmode:
                Toast.makeText(this,"darkMode",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.aboutUs:
                Toast.makeText(this,"aboutUs",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setTextOnEdittext(String desimal, String binary, String octel, String hexa) {
        edtDesimal.setText(desimal);
        edtHex.setText(hexa.toUpperCase());
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
            case R.id.btnDel:
                if(!text.equals("")){
                    text = text.substring(0,text.length()-1);
                    value = "";
                    isHoverAndGetId.setText(text);
                }
                break;
            case R.id.btnAc:
                edtBinary.setText("");
                break;
            /*case R.id.btnSave:
                break;
            case R.id.btnHistory:
                break;*/
            case R.id.btnCo:
                copyString("Octel",edtOctel.getText().toString());
                break;
            case R.id.btnCd:
                copyString("Desimal",edtDesimal.getText().toString());
                break;
            case R.id.btnCb:
                copyString("Binary",edtBinary.getText().toString());
                break;
            case R.id.btnCh:
                copyString("Hexa-desimal",edtHex.getText().toString());
                break;
        }
        isHoverAndGetId.append(value);
    }

    private void copyString(String label,String text) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);

        Toast toast = Toast.makeText(this,"Copied!",Toast.LENGTH_SHORT);
        View view = toast.getView();

        //Gets the actual oval background of the Toast then sets the colour filter
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        //Gets the TextView from the Toast so it can be editted
        TextView t = view.findViewById(android.R.id.message);
        t.setTextColor(getResources().getColor(R.color.colorDark));
        toast.show();
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.edtBinary:
                isHoverAndGetId = edtBinary;
                hoverTeextId = txtb;
                setBackground(b,edtBinary);
                Log.d("tg", "edtBinary");
                break;
            case R.id.edtDesimal:
                isHoverAndGetId = edtDesimal;
                hoverTeextId = txtd;
                setBackground(b,edtDesimal);
                Log.d("tg", "edtDesimal");
                break;
            case R.id.edtOctel:
                isHoverAndGetId = edtOctel;
                hoverTeextId = txto;
                setBackground(b,edtOctel);
                Log.d("tg", "edtOctel");
                break;
            case R.id.edtHex:
                isHoverAndGetId = edtHex;
                hoverTeextId = txth;
                setBackground(b,edtHex);
                Log.d("tg", "edtHex");
                break;
        }
    }

    private void setBackground(boolean b,EditText e) {
       if(!b){
           hoverTeextId.setBackgroundColor(getResources().getColor(R.color.colorAccent));
           hoverTeextId.setTextColor(getResources().getColor(R.color.colorDark));
           if(e == edtBinary){
                binaryUnSetBg();
           }
           else if(e == edtDesimal){
                desimalUnSetBg();
           }
           else if(e == edtHex){
                hexaUnSetBg();
           }
           else{
                octelUnSetBg();
           }
       }
       else{
           hoverTeextId.setBackgroundColor(getResources().getColor(R.color.colorMiniRed));
           hoverTeextId.setTextColor(getResources().getColor(R.color.colorWhite));
           if(e == edtBinary){
               binarySetBg();
           }
           else if(e == edtDesimal){
               desimalSetBg();
           }
           else if(e == edtHex){
                hexaSetBg();
           }
           else{
                octelSetBg();
           }
       }
    }

    private void octelUnSetBg() {
        binaryUnSetBg();
        unSetBackgroundColorRed(btn2);
        unSetBackgroundColorRed(btn3);
        unSetBackgroundColorRed(btn4);
        unSetBackgroundColorRed(btn5);
        unSetBackgroundColorRed(btn6);
        unSetBackgroundColorRed(btn7);
        unSetTextColorWhite(btn2);
        unSetTextColorWhite(btn3);
        unSetTextColorWhite(btn4);
        unSetTextColorWhite(btn5);
        unSetTextColorWhite(btn6);
        unSetTextColorWhite(btn7);
    }

    private void hexaUnSetBg() {
        desimalUnSetBg();
        unSetBackgroundColorRed(btnA);
        unSetBackgroundColorRed(btnB);
        unSetBackgroundColorRed(btnC);
        unSetBackgroundColorRed(btnD);
        unSetBackgroundColorRed(btnE);
        unSetBackgroundColorRed(btnF);
        unSetTextColorWhite(btnA);
        unSetTextColorWhite(btnB);
        unSetTextColorWhite(btnC);
        unSetTextColorWhite(btnD);
        unSetTextColorWhite(btnE);
        unSetTextColorWhite(btnF);
    }

    private void desimalUnSetBg() {
        octelUnSetBg();
        unSetBackgroundColorRed(btn8);
        unSetBackgroundColorRed(btn9);
        unSetTextColorWhite(btn8);
        unSetTextColorWhite(btn9);
    }

    private void binaryUnSetBg() {
        unSetBackgroundColorRed(btn0);
        unSetBackgroundColorRed(btn1);
        unSetTextColorWhite(btn0);
        unSetTextColorWhite(btn1);
    }

    private void octelSetBg() {
        binarySetBg();
        setBackgroundColorRed(btn2);
        setBackgroundColorRed(btn3);
        setBackgroundColorRed(btn4);
        setBackgroundColorRed(btn5);
        setBackgroundColorRed(btn6);
        setBackgroundColorRed(btn7);
        setTextColorWhite(btn2);
        setTextColorWhite(btn3);
        setTextColorWhite(btn4);
        setTextColorWhite(btn5);
        setTextColorWhite(btn6);
        setTextColorWhite(btn7);
    }

    private void hexaSetBg(){
        desimalSetBg();
        setBackgroundColorRed(btnA);
        setBackgroundColorRed(btnB);
        setBackgroundColorRed(btnC);
        setBackgroundColorRed(btnD);
        setBackgroundColorRed(btnE);
        setBackgroundColorRed(btnF);
        setTextColorWhite(btnA);
        setTextColorWhite(btnB);
        setTextColorWhite(btnC);
        setTextColorWhite(btnD);
        setTextColorWhite(btnE);
        setTextColorWhite(btnF);
    }

    private void desimalSetBg() {
        octelSetBg();
        setBackgroundColorRed(btn8);
        setBackgroundColorRed(btn9);
        setTextColorWhite(btn8);
        setTextColorWhite(btn9);
    }

    private void binarySetBg() {
        setBackgroundColorRed(btn0);
        setBackgroundColorRed(btn1);
        setTextColorWhite(btn0);
        setTextColorWhite(btn1);
    }

    private void setTextColorWhite(Button e) {
        e.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    private void setBackgroundColorRed(Button e) {
        e.setBackgroundColor(getResources().getColor(R.color.colorMiniRed));
    }

    private void unSetTextColorWhite(Button e) {
        e.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    private void unSetBackgroundColorRed(Button e) {
        e.setBackground(getResources().getDrawable(R.drawable.btn_keypad_shape));
    }
}