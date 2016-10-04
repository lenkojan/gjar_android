package sk.gjar_po.loginformapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// definicia triedy pre LoginActivity
public class LoginActivity extends AppCompatActivity {

    // odkaz na editacne pole na zadanie prihlasovacieho mena
    EditText mLoginEditText;
    // odkaz na editacne pole na zadanie hesla
    EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nastavenie uzivatelskeho rozhrania definovaneho v activity_login.xml
        setContentView(R.layout.activity_login);
        // nastavenia odkazov na editacne polia pre login a password
        mLoginEditText = (EditText) findViewById(R.id.login);
        mPasswordEditText = (EditText) findViewById(R.id.password);
        // definicia akcie volanej pri stlaceni tlacidla s priradenym Id button
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ziskanie textu z editacneho pola pre login
                String login = mLoginEditText.getText().toString();
                // ziskanie textu z editacneho pola pre password
                String password = mPasswordEditText.getText().toString();
                // overenie ci login a password boli vyplnene
                if (!"".equals(login) && !"".equals(password)) {
                    // ak ano tak zavolaj metodu dispatchSuccessIntent s vyplnenym login a password
                    dispatchSuccessIntent(login, password);
                } else {
                    // ak nie tak zobraz hlasku
                    Toast.makeText(LoginActivity.this, "Please provide a login and password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    // metoda na odoslanie dat obrazovke SuccessActivity
    private void dispatchSuccessIntent(String login, String password) {
        // vytvorenie systemoveho volania
        Intent intent = new Intent(this, SuccessActivity.class);
        // vytvorenie a naplnenie objektu na prenos dat
        Bundle b = new Bundle();
        b.putString(SuccessActivity.ARG_LOGIN, login);
        b.putString(SuccessActivity.ARG_PASSWORD, password);
        // priradenie dat systemovemu volaniu
        intent.putExtras(b);
        // odoslanie systemoveho volania
        startActivity(intent);
    }
}
