package com.example.cardr;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ImageView cardP1_1, cardP1_2,  cardP1_3,  cardP1_4;
    private ImageView cardP2_1, cardP2_2,  cardP2_3,  cardP2_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardP1_1 = findViewById(R.id.cardP1_1);
        cardP1_2 = findViewById(R.id.cardP1_2);
        cardP1_3 = findViewById(R.id.cardP1_3);
        cardP1_4 = findViewById(R.id.cardP1_4);

        cardP2_1 = findViewById(R.id.cardP2_1);
        cardP2_2 = findViewById(R.id.cardP2_2);
        cardP2_3 = findViewById(R.id.cardP2_3);
        cardP2_4 = findViewById(R.id.cardP2_4);
    }
    public void intilazeGame(){
            Deck deck = new Deck();
            Hand player1Hand = new Hand();
            Hand player2Hand = new Hand();
            Hand table = new Hand();

            Round round = new Round(deck, player1Hand, player2Hand,table,0,0);

    }
}