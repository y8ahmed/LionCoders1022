package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

public class ConfirmActivity extends AppCompatActivity {
    int max;
    int min;
    int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Log.d("ConfirmActivity","onCreate");
        Intent i = getIntent();
        max = i.getIntExtra("max", 0);
        min = i.getIntExtra("min", 10);
        times = i.getIntExtra("times", 8);
        Log.d("ConfirmActivity",String.format("onCreate max=%d min=%d times=%d", max, min, times));

        TextView numrange_view = (TextView) findViewById(R.id.NumRange);
        TextView numtimes_view = (TextView) findViewById(R.id.NumTimes);

        String numrange = numrange_view.getText().toString();
        String numtimes = numtimes_view.getText().toString();

        numrange_view.setText(String.format(numrange, min, max));
        numtimes_view.setText(String.format(numtimes, times));
    }

    public void openGamePage(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        Log.d("ConfirmActivity","openGamePage");
        intent.putExtra("max", max);
        intent.putExtra("min", min);
        intent.putExtra("times", times);
        Log.d("ConfirmActivity",String.format("openGamePage max=%d min=%d times=%d", max, min, times));
        startActivity(intent);
    }
}