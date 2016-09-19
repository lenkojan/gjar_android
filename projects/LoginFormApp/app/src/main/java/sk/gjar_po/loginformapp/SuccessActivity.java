package sk.gjar_po.loginformapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class SuccessActivity extends AppCompatActivity {

    public static final String ARG_LOGIN = "login";
    public static final String ARG_PASSWORD = "password";

    EditText mLoginTextView;
    EditText mPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        mLoginTextView = (EditText) findViewById(R.id.login);
        mLoginTextView.setKeyListener(null);
        mPasswordTextView = (EditText) findViewById(R.id.password);
        mPasswordTextView.setKeyListener(null);
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey(ARG_LOGIN)) {
                mLoginTextView.setText(getIntent().getExtras().getString(ARG_LOGIN));
            }
            if (getIntent().getExtras().containsKey(ARG_PASSWORD)) {
                mPasswordTextView.setText(getIntent().getExtras().getString(ARG_PASSWORD));
            }
        }
    }

}
