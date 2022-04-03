package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;

public class CustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
    }

    public void openConfirmPage(View view)  {
        EditText max_text = (EditText)findViewById(R.id.MaxNum);
        EditText min_text  = (EditText)findViewById(R.id.MinNum);
        EditText guess_text  = (EditText)findViewById(R.id.GuessTime);

        Integer max = Integer.parseInt(max_text.getText().toString());
        Integer min = Integer.parseInt(min_text.getText().toString());
        Integer times = Integer.parseInt(guess_text.getText().toString());

        Intent intent = new Intent(this, ConfirmActivity.class);
        Log.d("CustomizeActivity","openConfirmPage");
        intent.putExtra("max", max);
        intent.putExtra("min", min);
        intent.putExtra("times", times);
        Log.d("CustomizeActivity",String.format("openConfirmPage max=%d min=%d times=%d", max, min, times));
        startActivity(intent);
    }
}