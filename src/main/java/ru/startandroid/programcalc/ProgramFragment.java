package ru.startandroid.programcalc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

import org.mariuszgromada.math.mxparser.Expression;

import java.math.BigInteger;
import java.util.LinkedList;

public class ProgramFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    public final static String ARG_BASE = "base";

    BigInteger resDec;
    String result;
    boolean isGetResult = false;

    String strNumberBin;
    String strNumberOct;
    String strNumberDec;
    String strNumberHex;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnDel;
    Button btnPlus;
    Button btnMinus;
    Button btnDivide;
    Button btnX;
    Button btnEqual;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnE;
    Button btnF;
    Button btnOpen;
    Button btnClose;

    LinearLayout linLayout;
    EditText editText;
    EditText editTextBin;
    EditText editTextOct;
    EditText editTextDec;
    EditText editTextHex;

    public static Fragment newInstance(String base) {
        Bundle arguments = new Bundle();
        arguments.putString(ARG_BASE, base);
        ProgramFragment programFragment = new ProgramFragment();
        programFragment.setArguments(arguments);
        return programFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        switch (getArguments().getString(ARG_BASE)) {
            case "BIN":
                view = inflater.inflate(R.layout.fragment_layout_program_bin, container, false);
                break;
            case "OCT":
                view = inflater.inflate(R.layout.fragment_layout_program_oct, container, false);
                break;
            case "DEC":
                view = inflater.inflate(R.layout.fragment_layout_program_dec, container, false);
                break;
            case "HEX":
                view = inflater.inflate(R.layout.fragment_layout_program_hex, container, false);
                break;
        }

        initiatelayout(view);
        return view;
    }

    public void initiatelayout(View view) {
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
        btnDel = (Button) view.findViewById(R.id.btnDel);
        btnPlus = (Button) view.findViewById(R.id.btnPlus);
        btnMinus = (Button) view.findViewById(R.id.btnMinus);
        btnDivide = (Button) view.findViewById(R.id.btnDivide);
        btnX = (Button) view.findViewById(R.id.btnX);
        btnEqual = (Button) view.findViewById(R.id.btnEqual);

        btnOpen = (Button) view.findViewById(R.id.btnOpen);
        btnClose = (Button) view.findViewById(R.id.btnClose);

        btnOpen.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnDel.setOnLongClickListener(this);

        editText = (EditText) view.findViewById(R.id.editText);

        editTextBin = (EditText) view.findViewById(R.id.editTextBin);
        editTextOct = (EditText) view.findViewById(R.id.editTextOct);
        editTextDec = (EditText) view.findViewById(R.id.editTextDec);
        editTextHex = (EditText) view.findViewById(R.id.editTextHex);

        btnA = (Button) view.findViewById(R.id.btnA);
        btnB = (Button) view.findViewById(R.id.btnB);
        btnC = (Button) view.findViewById(R.id.btnC);
        btnD = (Button) view.findViewById(R.id.btnD);
        btnE = (Button) view.findViewById(R.id.btnE);
        btnF = (Button) view.findViewById(R.id.btnF);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);

        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
    }

    void writeText(String text) {
        editText.setText(text);
        editText.setSelection(editText.getText().length());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOpen: {
                canClear();
                writeText(editText.getText().toString() + "(");
                isGetResult = false;
                break;
            }
            case R.id.btnClose: {
                canClear();
                writeText(editText.getText().toString() + ")");
                isGetResult = false;
                break;
            }
            case R.id.btnA: {
                canClear();
                writeText(editText.getText().toString() + "A");
                isGetResult = false;
                break;
            }
            case R.id.btnB: {
                canClear();
                writeText(editText.getText().toString() + "B");
                isGetResult = false;
                break;
            }
            case R.id.btnC: {
                canClear();
                writeText(editText.getText().toString() + "C");
                isGetResult = false;
                break;
            }
            case R.id.btnD: {
                canClear();
                writeText(editText.getText().toString() + "D");
                isGetResult = false;
                break;
            }
            case R.id.btnE: {
                canClear();
                writeText(editText.getText().toString() + "E");
                isGetResult = false;
                break;
            }
            case R.id.btnF: {
                canClear();
                writeText(editText.getText().toString() + "F");
                isGetResult = false;
                break;
            }
            case R.id.btn1: {
                canClear();
                writeText(editText.getText().toString() + "1");
                isGetResult = false;
                break;
            }
            case R.id.btn2: {
                canClear();
                writeText(editText.getText().toString() + "2");
                isGetResult = false;
                break;
            }
            case R.id.btn3: {
                canClear();
                writeText(editText.getText().toString() + "3");
                isGetResult = false;
                break;
            }
            case R.id.btn4: {
                canClear();
                writeText(editText.getText().toString() + "4");
                isGetResult = false;
                break;
            }
            case R.id.btn5: {
                canClear();
                writeText(editText.getText().toString() + "5");
                isGetResult = false;
                break;
            }
            case R.id.btn6: {
                canClear();
                writeText(editText.getText().toString() + "6");
                isGetResult = false;
                break;
            }
            case R.id.btn7: {
                canClear();
                writeText(editText.getText().toString() + "7");
                isGetResult = false;
                break;
            }
            case R.id.btn8: {
                canClear();
                writeText(editText.getText().toString() + "8");
                isGetResult = false;
                break;
            }
            case R.id.btn9: {
                canClear();
                writeText(editText.getText().toString() + "9");
                isGetResult = false;
                break;
            }
            case R.id.btnPlus: {
                String text = editText.getText().toString();
                if (isTextEmpty()) {
                    return;
                }
                if (!isOperator(text.charAt(text.length() - 1))) {
                    canClear();
                    writeText(text + "+");
                    isGetResult = false;
                }
                break;
            }
            case R.id.btnMinus: {
                String text = editText.getText().toString();
                if (isTextEmpty()) {
                    return;
                }
                if (!isOperator(text.charAt(text.length() - 1))) {
                    canClear();
                    writeText(text + "-");
                    isGetResult = false;
                }
                break;
            }
            case R.id.btnDivide: {
                String text = editText.getText().toString();
                if (isTextEmpty()) {
                    return;
                }
                if (!isOperator(text.charAt(text.length() - 1))) {
                    canClear();
                    writeText(text + "/");
                    isGetResult = false;
                }
                break;
            }
            case R.id.btnX: {
                String text = editText.getText().toString();
                if (isTextEmpty()) {
                    return;
                }
                if (!isOperator(text.charAt(text.length() - 1))) {
                    canClear();
                    writeText(text + "*");
                    isGetResult = false;
                }
                break;
            }
            case R.id.btn0: {
                String text = editText.getText().toString();
                if (text.equals("0")) {
                    return;
                } else {
                    canClear();
                    writeText(text + "0");
                    isGetResult = false;
                }
                break;
            }
            case R.id.btnDel: {
                String text = editText.getText().toString();
                if (text.length() == 0) {
                    return;
                } else {
                    writeText(text.substring(0, text.length() - 1));
                    isGetResult = false;
                }
                break;
            }
            case R.id.btnEqual: {

                if (isGetResult) {
                    return;
                }

                String text = editText.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    return;
                } else if (isOperator(text.charAt(text.length() - 1))) {
                    text = text.substring(0, text.length() - 1);
                    writeText(text);
                }

                switch (getArguments().getString(ARG_BASE)) {
                    case "BIN":
                        resDec = gerResultInDec(text, 2);

                        writeText(resDec.toString(2));
                        isGetResult = true;

                        strNumberOct = convertTo(resDec, 8);
                        Log.d("strNumberOct", "" + strNumberOct);

                        strNumberDec = convertTo(resDec, 10);
                        Log.d("strNumberDec", "" + strNumberDec);

                        strNumberHex = resDec.toString(16);
                        Log.d("strNumberHex", "" + strNumberHex);

                        editTextOct.setText(strNumberOct);
                        editTextDec.setText(strNumberDec);
                        editTextHex.setText(strNumberHex);
                        break;
                    case "OCT":
                        resDec = gerResultInDec(text, 8);

                        writeText(resDec.toString(8));
                        isGetResult = true;

                        strNumberBin = convertTo(resDec, 2);
                        Log.d("strNumberBin", "" + strNumberBin);

                        strNumberDec = convertTo(resDec, 10);
                        Log.d("strNumberDec", "" + strNumberDec);

                        strNumberHex = resDec.toString(16);
                        Log.d("strNumberHex", "" + strNumberHex);

                        editTextBin.setText(strNumberBin);
                        editTextDec.setText(strNumberDec);
                        editTextHex.setText(strNumberHex);
                        break;
                    case "DEC":
                        resDec = gerResultInDec(text, 10);

                        writeText(resDec.toString(10));
                        isGetResult = true;

                        strNumberBin = convertTo(resDec, 2);
                        Log.d("strNumberBin", "" + strNumberBin);

                        strNumberOct = convertTo(resDec, 8);
                        Log.d("strNumberOct", "" + strNumberOct);

                        strNumberHex = resDec.toString(16);
                        Log.d("strNumberHex", "" + strNumberHex);

                        editTextBin.setText(strNumberBin);
                        editTextOct.setText(strNumberOct);
                        editTextHex.setText(strNumberHex);
                        break;
                    case "HEX":
                        resDec = gerResultInDec(text, 16);

                        writeText(resDec.toString(16));
                        isGetResult = true;

                        strNumberBin = convertTo(resDec, 2);
                        Log.d("strNumberBin", "" + strNumberBin);

                        strNumberOct = convertTo(resDec, 8);
                        Log.d("strNumberOct", "" + strNumberOct);

                        strNumberDec = convertTo(resDec, 10);
                        Log.d("strNumberDec", "" + strNumberDec);

                        editTextBin.setText(strNumberBin);
                        editTextOct.setText(strNumberOct);
                        editTextDec.setText(strNumberDec);
                        break;
                }
            }
        }
    }

    String convertTo(BigInteger number, int baseTo) {
        BigInteger bi = new BigInteger(number.toString(baseTo));
        Log.d("BI", "" + bi);
        String result = String.format("%,d", bi);
        Log.d("RESULT", "" + result);
        return result;
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isTextEmpty() {
        return editText.getText().toString().equals("");
    }

    int priority(char oper) {
        // Если символ * или / - приоритет 1
        if (oper == '*' || oper == '/') {
            return 1;
        }
        // Если символ + или - — приоритет 0
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        // Если ни то, ни другое - приоритет -1
        else {
            return -1;
        }
    }

    boolean calculate(LinkedList<BigInteger> st, char oper) {
        // Инициализируем и объявляем две переменные
        // Первая берет последнее значение из переданного
        // связанного листа в параметре, запоминает и удаляет
        // его из списка
        BigInteger someOne = st.removeLast();

        BigInteger someTwo = st.removeLast();

        switch (oper) {
            case '+':
                st.add(someTwo.add(someOne));
                return true;
            case '-':
                st.add(someTwo.subtract(someOne));
                return true;
            case '*':
                st.add(someTwo.multiply(someOne));
                return true;
            case '/':
                try {
                    st.add(someTwo.divide(someOne));
                    return true;
                } catch (ArithmeticException ex) {
                    Log.d("ERROR", "error");
                    return false;
                }
            default:
                System.out.println("Oops");
        }
        return true;
    }

    BigInteger gerResultInDec(String s, int baseFrom) {

        // Создаем два контейнера типа LinkedList
        // Один для чисел, другой для символов
        LinkedList<BigInteger> someNumbers = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();

        // Пишем цикл, который бегает по нашей строке
        for (int i = 0; i < s.length(); i++) {

            // Создаем локальную переменную типа символ,
            // чтобы было с чем делать сравнения и работать.
            // Присваиваем ей текущее положение i в строке
            char c = s.charAt(i);

            // Если натыкаемся на открывающуюся скобку
            if (c == '(') {

                // Добавляем открывающуюся скобку в контейнер
                // символов
                someOpers.add('(');

            }

            // Если натыкаемся на закрывающуюся скобку
            else if (c == ')') {

                // Смотрим - пока последний символ контейнера
                // символов не открывающаяся скобка -
                // Выполняем метод, который учит считать
                // программу, передавая ему в параметрах
                // наш контейнер с числами и последний
                // символ в контейнере символов, причем
                // удаляя его опосля
                while (someOpers.getLast() != '(') {
                    boolean isGood = calculate(someNumbers, someOpers.removeLast());
                    if (!isGood) {
                        return new BigInteger("0");
                    }
                }

                // После while - удаляем последний символ
                // из Символьного Контейнера. Если смотреть
                // пример - это открывающаяся скобка
                someOpers.removeLast();
            }

            // Так же, во время цикла мы проверяем каждый символ
            // на предмет - а не оператор ли он часом?
            // Если же да, то
            // ПОКА массив символов непустой и приоритет
            // последнего символа в контейнере символов
            // больше или равен приоритету текущего -
            // "учим" программу считать, передавая в параметрах
            // контейнер с числами и последний символ из
            // контейнера символов, удаляя его опосля
            else if (isOperator(c)) {
                while (!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {

                    boolean isGood = calculate(someNumbers, someOpers.removeLast());
                    if (!isGood) {
                        return new BigInteger("0");
                    }
                }

                // Если while не выполняется - добавляем
                // символ в контейнер символов
                someOpers.add(c);
            }

            // Если же ничего из вышеперечисленного не произошло,
            // то мы ожидаем число
            else if (Character.isDigit(c) || Character.isLetter(s.charAt(i))) {
                String operand = "";

                // После чего, ПОКА
                // текущее i меньше размера строки и
                // позиция от i в строке - число, -
                // мы составляем строку числа из символов,
                // увеличивая i на 1 каждый раз, когда символ
                // записался, чтобы проверять строку дальше

                while ((i < s.length() && Character.isDigit(s.charAt(i))) || Character.isLetter(s.charAt(i))) {
                    operand += s.charAt(i++);
                    if (i == s.length()) {
                        break;
                    }
                }

                // Если while не выполнился или закончился -
                // отнимаем у i единицу (т.к. i++ отработала
                // лишний раз, и добавляем нашу
                // распарсенную в числовой манер строку,
                // которую мы составили из чисел в
                // Числовой Контейнер
                --i;
                Log.d("operand", "" + operand);
                someNumbers.add(new BigInteger(operand, baseFrom));
                Log.d("BigInteger10", "" + new BigInteger(operand, baseFrom));
            }
        }

        // После цикла,
        // ПОКА контейнер символов НЕ пустой, -
        // "учим" считать программу, передавая ей наш контейнер
        // чисел и контейнер символов.
        while (!someOpers.isEmpty()) {
            boolean isGood = calculate(someNumbers, someOpers.removeLast());
            if (!isGood) {
                return new BigInteger("0");
            }
        }

        return someNumbers.get(0);
    }

    void canClear() {
        if (isGetResult) {
            clearEdits();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        isGetResult = false;
        clearEdits();
        return true;
    }

    void clearEdits() {
        editText.setText("");
        if (editTextBin != null) {
            editTextBin.setText("");
        }
        if (editTextOct != null) {
            editTextOct.setText("");
        }
        if (editTextDec != null) {
            editTextDec.setText("");
        }
        if (editTextHex != null) {
            editTextHex.setText("");
        }
    }
}