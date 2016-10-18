package com.gjar_po.dialogdelaysample;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //dialog
    private ProgressDialog mProgressDialog;
    //vedlajsie vlakno na kontrolu delay
    private AsyncTask<Void, Void, Void> mDelayTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAction();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        cancelDelay();
    }

    private void cancelDelay() {
        if (mDelayTask != null)
            mDelayTask.cancel(true);
        if (mProgressDialog != null)
            mProgressDialog.dismiss();
    }

    private void startAction() {
        cancelDelay();
        //vytvorenie dialogu
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading");
        mProgressDialog.setMessage("Wait while loading...");
        mProgressDialog.show();
        //vytvorenie 2 vlakna
        mDelayTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    //delay 4 sekundy
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
            // toto sa vykona po dokonceni metody doInBackground na hlavnom vlakne
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (mProgressDialog != null)
                    mProgressDialog.dismiss();
                doPostDelayThings();
            }
        };
        mDelayTask.execute((Void[]) null);
    }

    private void doPostDelayThings() {
        // tu treba logiku ktora sa vykona po zruseni dialogu
    }
}
