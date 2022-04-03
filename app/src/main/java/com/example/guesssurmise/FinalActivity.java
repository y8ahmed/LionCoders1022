package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    String status;
    int answer;
    String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        status = i.getStringExtra("status");
        answer = i.getIntExtra("answer", 0);
        score = i.getStringExtra("score");

        Log.d("FinalActivity", String.format("onCreate status=%s answer=%d ", status, answer));
        Log.d("FinalActivity", String.format("onCreate %b %b", status.equals("lost"), status.equals("won")));

        TextView status_edit = (TextView) findViewById(R.id.status);
        if (status.equals("lost")) {
            status_edit.setText(String.format("You lost (score = 0) and the answer was %d", answer));
        } else if (status.equals("won")) {
            status_edit.setText(String.format("You won (score = %s) and the answer was %d", score, answer));
        }
    }

    public void openExit(View view) {
        Log.d("FinalActivity","openExit");
        finishAffinity();
        System.exit(0);
    }

    public void openRetry(View view) {
        Log.d("FinalActivity","openRetry");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}