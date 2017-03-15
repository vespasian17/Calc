package ru.startandroid.programcalc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;

public class IngenerFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener{

    Button btn1;Button btn2;Button btn3;Button btn4;Button btn5;Button btn6;Button btn7;Button btn8;Button btn9;Button btn0;
    Button btnDelete;Button btnDot;Button btnPlus;Button btnMinus;Button btnDivide;Button btnX;Button btnEqual;Button btnOpen;
    Button btnClose;Button btnSin;Button btnCos;Button btnTan;Button btnFak;Button btnLog;Button btnLn;Button btnSqrt;Button btnPow;

    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_ingener, container, false);
        initiatelayout(view);
        return view;
    }

    public void initiatelayout(View view){
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);
        btn0 = (Button) view.findViewById(R.id.btn0);
        btnDot = (Button) view.findViewById(R.id.btnDot);
        btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnPlus = (Button) view.findViewById(R.id.btnPlus);
        btnMinus = (Button) view.findViewById(R.id.btnMinus);
        btnDivide = (Button) view.findViewById(R.id.btnDivide);
        btnX = (Button) view.findViewById(R.id.btnX);
        btnEqual = (Button) view.findViewById(R.id.btnEqual);

        editText = (EditText) view.findViewById(R.id.editText);

        btnOpen = (Button)view.findViewById(R.id.btnOpen);
        btnClose = (Button)view.findViewById(R.id.btnClose);

        btnSin = (Button) view.findViewById(R.id.btnSin);
        btnCos = (Button) view.findViewById(R.id.btnCos);
        btnTan = (Button) view.findViewById(R.id.btnTan);
        btnFak = (Button) view.findViewById(R.id.btnFak);
        btnLog = (Button) view.findViewById(R.id.btnLog);
        btnLn = (Button) view.findViewById(R.id.btnLn);
        btnSqrt = (Button) view.findViewById(R.id.btnSqrt);
        btnPow = (Button) view.findViewById(R.id.btnPow);

        btn1.setOnClickListener(this);btn2.setOnClickListener(this);btn3.setOnClickListener(this);btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);btn6.setOnClickListener(this);btn7.setOnClickListener(this);btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);btn0.setOnClickListener(this);btnDelete.setOnClickListener(this);btnDot.setOnClickListener(this);
        btnPlus.setOnClickListener(this);btnMinus.setOnClickListener(this);btnDivide.setOnClickListener(this);btnX.setOnClickListener(this);
        btnEqual.setOnClickListener(this);btnOpen.setOnClickListener(this);btnClose.setOnClickListener(this);

        btnDelete.setOnLongClickListener(this);

        if (btnSin != null) {
            btnSin.setOnClickListener(this);
            btnCos.setOnClickListener(this);
            btnTan.setOnClickListener(this);
            btnFak.setOnClickListener(this);
            btnLog.setOnClickListener(this);
            btnLn.setOnClickListener(this);
            btnSqrt.setOnClickListener(this);
            btnPow.setOnClickListener(this);
        }
    }

    void writeText(String text){
        editText.setText(text);
        editText.setSelection(editText.getText().length());
    }

    @Override
    public void onClick(View v) {
        String text = editText.getText().toString();
        switch (v.getId()) {
            case R.id.btnSqrt: {
                writeText(text + "sqrt(");
                break;
            }case R.id.btnPow: {
                writeText(text + "^");
                break;
            }case R.id.btnSin: {
                writeText(text + "sin(");
                break;
            }case R.id.btnCos: {
                writeText(text + "cos(");
                break;
            }case R.id.btnTan: {
                writeText(text + "tan(");
                break;
            }case R.id.btnFak: {
                writeText(text + "!");
                break;
            }case R.id.btnLog: {
                writeText(text + "log10(");
                break;
            }case R.id.btnLn: {
                writeText(text + "ln(");
                break;
            }case R.id.btnOpen: {
                writeText(text + "(");
                break;
            }case R.id.btnClose: {
                writeText(text + ")");
                break;
            }case R.id.btn1: {
                writeText(text + "1");
                break;
            }
            case R.id.btn2: {
                writeText(text + "2");
                break;
            }case R.id.btn3: {
                writeText(text + "3");
                break;
            }case R.id.btn4: {
                writeText(text + "4");
                break;
            }case R.id.btn5: {
                writeText(text + "5");
                break;
            }case R.id.btn6: {
                writeText(text + "6");
                break;
            }case R.id.btn7: {
                writeText(text + "7");
                break;
            }case R.id.btn8: {
                writeText(text + "8");
                break;
            }case R.id.btn9: {
                writeText(text + "9");
                break;
            }
            case R.id.btnPlus: {
                if(isTextEmpty()){
                    return;
                }
                if(!isOperator(text.charAt(text.length() - 1))){
                    writeText(text + "+");
                }
                break;
            }case R.id.btnMinus: {
                if(isTextEmpty()){
                    return;
                }
                if(!isOperator(text.charAt(text.length() - 1))){
                    writeText(text + "-");
                }
                break;
            }case R.id.btnDivide: {
                if(isTextEmpty()){
                    return;
                }
                if(!isOperator(text.charAt(text.length() - 1))){
                    writeText(text + "/");
                }
                break;
            }case R.id.btnX: {
                if(isTextEmpty()){
                    return;
                }
                if(!isOperator(text.charAt(text.length() - 1))){
                    writeText(text + "*");
                }
                break;
            }case R.id.btn0: {
                if (text.equals("0")) {
                    return;
                } else{
                    writeText(text + "0");
                }
                break;
            }case R.id.btnDot: {
                if (isTextEmpty()) {
                    return;
                } else if (text.charAt(text.length() - 1) == '.') {
                    return;
                } else {
                    writeText(text + ".");
                }
                break;
            }case R.id.btnDelete: {
                if (text.length() == 0) {
                    return;
                } else {
                    writeText(text.substring(0, text.length() - 1));
                }
                break;
            }case R.id.btnEqual: {

                if(TextUtils.isEmpty(text)){
                    return;
                }
                Expression expression = new Expression(text);

                String resultStr = String.valueOf(expression.calculate());
                String stringAfterDot = "";
                int posDot;
                for(posDot = 1; posDot < resultStr.length(); posDot++){
                    if(resultStr.charAt(posDot) == '.'){
                        stringAfterDot = resultStr.substring(posDot + 1);
                        break;
                    }
                }

                for(int posNotZero = 0; posNotZero < stringAfterDot.length(); posNotZero++){
                    if(stringAfterDot.charAt(posNotZero) != '0'){
                        writeText(resultStr);
                        break;
                    }
                }

                if(editText.getText().toString().equals(text)){
                    writeText(resultStr.substring(0, posDot));
                }

                break;
            }
        }
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isTextEmpty() {
        return editText.getText().toString().equals("");
    }

    @Override
    public boolean onLongClick(View v) {
        editText.setText("");
        return true;
    }
}
