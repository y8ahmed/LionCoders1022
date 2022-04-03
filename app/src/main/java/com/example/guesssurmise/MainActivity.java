package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int theme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDefaultPage(View view)  {
        Intent intent = new Intent(this, DefaultActivity.class);
        intent.putExtra("theme", theme);
        startActivity(intent);
    }

    public void openCustomizePage(View view)  {
        Intent intent = new Intent(this, CustomizeActivity.class);
        intent.putExtra("theme", theme);
        startActivity(intent);
    }

    // theme
    public void themeDefault(View view)  {
        this.theme = 1;
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffffff"));
    }

    public void themeDesert(View view)  {
        this.theme = 2;
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FAD5A5"));
    }

    public void themeForest(View view)  {
        this.theme = 3;
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#1a4810"));
    }

    public void themeOcean(View view)  {
        this.theme = 4;
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#005b96"));
    }

}