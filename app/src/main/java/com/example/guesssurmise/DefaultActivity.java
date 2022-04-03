package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class DefaultActivity extends AppCompatActivity {

    int max;
    int min;
    int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

    }

    public void openConfirmPage(View view)  {
        Intent intent = new Intent(this, ConfirmActivity.class);
        Log.d("DefaultActivity","openConfirmPage");
        intent.putExtra("max", max);
        intent.putExtra("min", min);
        intent.putExtra("times", times);
        Log.d("DefaultActivity",String.format("openConfirmPage max=%d min=%d times=%d", max, min, times));
        startActivity(intent);
    }

    public void setEasyLevel(View view)  {
        Log.d("DefaultActivity","Easy level");
        min = 1;
        max = 10;
        times = 8;
    }

    public void setMediumLevel(View view)  {
        Log.d("DefaultActivity","Med level");
        min = 1;
        max = 25;
        times = 8;
    }

    public void setHardLevel(View view)  {
        Log.d("DefaultActivity", "Hard level");
        min = 1;
        max = 50;
        times = 5;
    }

}