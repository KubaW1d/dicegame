package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView pole1, pole2, pole3, pole4, pole5;
    private TextView wynik, wynik1, liczbaRzutow;

    private int licznikRzutow = 0;
    private int sumaGry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pole1 = findViewById(R.id.pole1);
        pole2 = findViewById(R.id.pole2);
        pole3 = findViewById(R.id.pole3);
        pole4 = findViewById(R.id.pole4);
        pole5 = findViewById(R.id.pole5);
        wynik = findViewById(R.id.wynik);
        wynik1 = findViewById(R.id.wynik1);
        liczbaRzutow = findViewById(R.id.liczbarzutow);
        Button rzut = findViewById(R.id.rzut);
        Button button = findViewById(R.id.button);

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void rollDice() {
        Random random = new Random();
        int[] kosc = new int[5];
        int[] count = new int[6];
        int wynikTegoLosowania = 0;


        for (int i = 0; i < 5; i++) {
            kosc[i] = random.nextInt(6) + 1;
            count[kosc[i] - 1]++;
        }

        pole1.setText(String.valueOf(kosc[0]));
        pole2.setText(String.valueOf(kosc[1]));
        pole3.setText(String.valueOf(kosc[2]));
        pole4.setText(String.valueOf(kosc[3]));
        pole5.setText(String.valueOf(kosc[4]));


        for (int i = 0; i < 6; i++) {
            if (count[i] >= 2) {
                wynikTegoLosowania += (i + 1) * count[i];
            }
        }

        wynik.setText("Wynik tego losowania: " + wynikTegoLosowania);
        sumaGry += wynikTegoLosowania;
        wynik1.setText("Wynik gry: " + sumaGry);
        licznikRzutow++;
        liczbaRzutow.setText("Liczba rzutów: " + licznikRzutow);
    }

    private void resetGame() {
        pole1.setText("?");
        pole2.setText("?");
        pole3.setText("?");
        pole4.setText("?");
        pole5.setText("?");

        wynik.setText("Wynik tego losowania: 0");
        wynik1.setText("Wynik gry: 0");
        liczbaRzutow.setText("Liczba rzutów: 0");

        licznikRzutow = 0;
        sumaGry = 0;
    }
}