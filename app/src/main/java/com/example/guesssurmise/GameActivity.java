package com.example.guesssurmise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    int max;
    int min;
    int times;
    int answer;
    int rounds;

    int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Log.d("GameActivity","onCreate");
        Intent i = getIntent();
        max = i.getIntExtra("max", 0);
        min = i.getIntExtra("min", 10);
        times = i.getIntExtra("times", 8);
        theme = i.getIntExtra("theme", 1);
        answer = getRandomNumberGen(min, max);

        if (theme == 1) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffffff"));
        } else if (theme == 2) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FAD5A5"));
        } else if (theme == 3) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#1a4810"));
        } else if (theme == 4) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#005b96"));
        }

        Log.d("GameActivity", String.format("onCreate max=%d min=%d times=%d secret=%d", max, min, times, answer));
        rounds = times;

        TextView round_text = (TextView) findViewById(R.id.Round);
        round_text.setText(String.format("%s %d",round_text.getText().toString(), rounds));
    }

    public int getRandomNumberGen(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    public void CheckGuess(View view) {
        EditText guess = (EditText) findViewById(R.id.GuessNumber);
        Log.d("GameActivity", String.format("CheckGuess: %s", guess.getText().toString()));
        if (guess.getText().toString() == "") {
            return;
        }
        Integer guess_num = Integer.parseInt(guess.getText().toString());

        if (guess_num == answer) {
            // exit to end page Won Game
            Log.d("GameActivity", String.format("CheckGuess:%d:(winner) %d=%d (total=%d)", rounds, guess_num, answer, times));

            Intent intent = new Intent(this, FinalActivity.class);
            Log.d("GameActivity","CheckGuess(winner)");
            intent.putExtra("status", "won");
            intent.putExtra("answer", answer);
            intent.putExtra("score", Integer.toString((rounds/times)*100));
            intent.putExtra("theme", theme);
            Log.d("GameActivity",String.format("CheckGuess(winner) status=%s answer=%d ", "won", answer));
            startActivity(intent);
        } else {
            // wrong number
            Log.d("GameActivity", String.format("CheckGuess:%d:(worng number) %d=%d (total=%d)", rounds, guess_num, answer, times));
            if (rounds == 0) {
                Log.d("GameActivity", String.format("CheckGuess:%d:(loser) %d=%d (total=%d)", rounds, guess_num, answer, times));

                Intent intent = new Intent(this, FinalActivity.class);
                Log.d("GameActivity","CheckGuess(loser)");
                intent.putExtra("status", "lost");
                intent.putExtra("answer", answer);
                intent.putExtra("score", "0");
                intent.putExtra("theme", theme);
                Log.d("GameActivity",String.format("CheckGuess(loser) status=%s answer=%d", "lost", answer));
                startActivity(intent);
            } else {
                rounds--;
                TextView round_text = (TextView) findViewById(R.id.Round);
                round_text.setText(String.format("%s %d","Round", rounds));
            }
        }

    }

}