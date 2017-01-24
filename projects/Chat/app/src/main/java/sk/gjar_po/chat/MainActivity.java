package sk.gjar_po.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSend = (Button) findViewById(R.id.send);
        mMessage = (EditText) findViewById(R.id.message);
        mChat = (TextView) findViewById(R.id.chat);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mRef = database.getReference("message");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object post = dataSnapshot.getValue(Object.class);
                Object[] chat = ((HashMap) post).values().toArray();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < chat.length; i++) {
                    sb.append(chat[i].toString()+"\n\n");
                }
                mChat.setText(sb.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child(String.valueOf(new Date().getTime())).setValue(mMessage.getText().toString());
            }
        });
    }

    class Chat extends HashMap<Integer, Object> {

    }
}
