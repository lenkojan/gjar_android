package sk.gjar_po.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float mResult = 0;
    String mSResult = "";
    TextView mText;
    TextView mSubText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.textView);
        mSubText = (TextView) findViewById(R.id.subTextView);
        mText.setText(String.valueOf(mResult));
        mSubText.setText(mSResult);
    }

    private void numOperation(int number) {
        mSResult = mSResult + String.valueOf(number);
        mSubText.setText(mSResult);
    }

    private void signOperation(String operand) {
        if (mSResult != "" && (mSResult.charAt(mSResult.length() - 1) != '+' && mSResult.charAt(mSResult.length() - 1) != '-')) {
            mSResult = mSResult + operand;
        }
        mSubText.setText(mSResult);
    }

    public void num_1(View v) {
        numOperation(1);
    }

    public void num_2(View v) {
        numOperation(2);
    }

    public void num_3(View v) {
        numOperation(3);
    }

    public void num_4(View v) {
        numOperation(4);
    }

    public void num_5(View v) {
        numOperation(5);
    }

    public void num_6(View v) {
        numOperation(6);
    }

    public void num_7(View v) {
        numOperation(7);
    }

    public void num_8(View v) {
        numOperation(8);
    }

    public void num_9(View v) {
        numOperation(9);
    }

    public void num_0(View v) {
        numOperation(0);
    }

    public void add(View v) {
        signOperation("+");
    }

    public void sub(View v) {
        signOperation("-");
    }

    public void open(View v) {
        //signOperation("(");
    }

    public void close(View v) {
        //signOperation(")");
    }

    public void sum(View v) {
        mText.setText(String.valueOf(eval(mSResult)));
    }

    public void clear(View v) {
        mSResult = "";
        mSubText.setText(String.valueOf(eval(mSResult)));
    }

    public float eval(String exp) {
        float output = 0;
        return output;
        /*
        int i = 0;
        String number = "";
        char operator = 'a';
        while (i < exp.length()) {
            if ("123456789".contains(String.valueOf(exp.charAt(i)))) {
                number += exp.charAt(i);
                i++;
            } else if ("+-".contains(String.valueOf(exp.charAt(i)))) {
                if (operator == '+') {
                    output += Integer.valueOf(number);
                    number = "";
                } else if (operator == '-') {
                    output -= Integer.valueOf(number);
                    number = "";
                } else {
                    output = Integer.valueOf(number);
                    number = "";
                }
                operator = exp.charAt(i);
                i++;
            }
            if (i == exp.length()) {
                if (operator == '+') {
                    output += Integer.valueOf(number);
                }
                if (operator == '-') {
                    output -= Integer.valueOf(number);
                }
            }
        }
        return output;
        */
    }
}
