package sk.gjar_po.loginformapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

// definicia triedy pre SuccessActivity
public class SuccessActivity extends AppCompatActivity {

    public static final String ARG_LOGIN = "login";
    public static final String ARG_PASSWORD = "password";

    // odkaz na zobrazovacie pole na zobrazenie prihlasovacieho mena
    EditText mLoginTextView;
    // odkaz na zobrazovacie pole na zobrazenie prihlasovacieho hesla
    EditText mPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nastavenie uzivatelskeho rozhrania definovaneho v activity_success.xml
        setContentView(R.layout.activity_success);
        // nastavenia odkazu na zobrazenie pola pre login
        mLoginTextView = (EditText) findViewById(R.id.login);
        // znefunkcnenie editacnej funkcionality
        mLoginTextView.setKeyListener(null);
        // nastavenia odkazu na zobrazenie pola pre login
        mPasswordTextView = (EditText) findViewById(R.id.password);
        // znefunkcnenie editacnej funkcionality
        mPasswordTextView.setKeyListener(null);
        // zistenie ci boli poslane data cez systemove volanie
        if (getIntent().getExtras() != null) {
            // zistenie ci bol poslany login a nastavenie poslanej hodnoty do widgetu mLoginTextView
            if (getIntent().getExtras().containsKey(ARG_LOGIN)) {
                mLoginTextView.setText(getIntent().getExtras().getString(ARG_LOGIN));
            }
            // zistenie ci bolp poslane heslo a nastavenie poslanej hodnoty do widgetu mPasswordTextView
            if (getIntent().getExtras().containsKey(ARG_PASSWORD)) {
                mPasswordTextView.setText(getIntent().getExtras().getString(ARG_PASSWORD));
            }
        }
    }

}
