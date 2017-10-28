package sk.gjar_po.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button mSend;
    EditText mMessage;
    DatabaseReference mRef;
    TextView mChat;
    Object o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSend = (Button) findViewById(R.id.send);
        mMessage = (EditText) findViewById(R.id.message);
        mChat = (TextView) findViewById(R.id.chat);

        AAAA a = new AAAA();
        mSend.setOnClickListener(a);
        Editable b = mMessage.getText();
    }

    class AAAA implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "aaaaaaa", Toast.LENGTH_LONG).show();
            String message = mMessage.getText().toString();
        }
    }
}
