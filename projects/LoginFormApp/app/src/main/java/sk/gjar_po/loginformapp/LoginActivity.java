package sk.gjar_po.loginformapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mLoginTextView;
    EditText mPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginTextView = (EditText) findViewById(R.id.login);
        mPasswordTextView = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = mLoginTextView.getText().toString();
                String password = mPasswordTextView.getText().toString();
                if (!login.equals("") && !password.equals("")) {
                    dispatchSuccessIntent(login, password);
                } else {
                    Toast.makeText(LoginActivity.this, "Please provide a login and password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void dispatchSuccessIntent(String login, String password) {
        Intent intent = new Intent(this, SuccessActivity.class);
        Bundle b = new Bundle();
        b.putString(SuccessActivity.ARG_LOGIN, login);
        b.putString(SuccessActivity.ARG_PASSWORD, password);
        intent.putExtras(b);
        startActivity(intent);
    }
}
