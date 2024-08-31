package com.example.cardr;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;

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
    public void initializeGame(){
        Deck deck = new Deck();
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();
        Hand table = new Hand();

        Round round = new Round(deck, player1Hand, player2Hand,table,0,0);

        dealInitialCard(player1Hand,player2Hand);
    }
    private void updateCardImage(ImageView cardImageView, Card card){
        // Generate the filename using the rank and suit
        String imageName = card.getSuit().toLowerCase()+"_of_"+card.getRank();
        // Use the filename to get the drawable resource ID
        int imageResource = getResources().getIdentifier(imageName, "drawable",getPackageName());
        // Set the drawable resource to the ImageView
        cardImageView.setImageResource(imageResource);

    }
    private void dealInitialCard(Hand player1Hand, Hand player2Hand){
        ArrayList<Card> player1Cards = player1Hand.getCards();
        ArrayList<Card> player2Cards = player2Hand.getCards();

        updateCardImage(findViewById(R.id.cardP1_1),player1Cards.get(0));
        updateCardImage(findViewById(R.id.cardP1_2),player1Cards.get(1));
        updateCardImage(findViewById(R.id.cardP1_3),player1Cards.get(2));
        updateCardImage(findViewById(R.id.cardP1_4),player1Cards.get(4));

        updateCardImage(findViewById(R.id.cardP2_1),player2Cards.get(0));
        updateCardImage(findViewById(R.id.cardP2_2),player2Cards.get(1));
        updateCardImage(findViewById(R.id.cardP2_3),player2Cards.get(2));
        updateCardImage(findViewById(R.id.cardP2_4),player2Cards.get(4));
    }

}