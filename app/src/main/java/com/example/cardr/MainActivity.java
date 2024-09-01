package com.example.cardr;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnCardSelectedListener{
    private ImageView cardP1_1, cardP1_2,  cardP1_3,  cardP1_4;
    private ImageView cardP2_1, cardP2_2,  cardP2_3,  cardP2_4;

    private Round round;
    private Hand player1Hand;
    private Hand player2Hand;

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

        //find the start game button by it's Id
        Button startGameButton = findViewById(R.id.start_game_button);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeGame();
            }
        });




        setCardTouchListener(cardP1_1,0);
        setCardTouchListener(cardP1_2,1);
        setCardTouchListener(cardP1_3,2);
        setCardTouchListener(cardP1_4,3);
    }
    @Override
    public void onCardSelected(Card selectedCard){
        if(selectedCard!=null) {
            round.onCardSelected(selectedCard);
        }else{
            enableCardSelection();
        }
    }
    private void setCardTouchListener(ImageView cardImageView,final int cardIndex ){
        cardImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    Card chosenCard = player1Hand.getCards().get(cardIndex);
                    Toast.makeText(MainActivity.this,"You selected"+chosenCard.toString(),Toast.LENGTH_SHORT).show();

                    //remove the card from the hand and update the UI
                    player1Hand.remove(chosenCard);
                    v.setVisibility(View.INVISIBLE);
                    return true;
                }
                return false;
            }
        });
    }
    private void enableCardSelection(){
        setCardTouchListener(cardP1_1,0);
        setCardTouchListener(cardP1_2,1);
        setCardTouchListener(cardP1_2,2);
        setCardTouchListener(cardP1_2,3);
    }
    public void initializeGame(){
        Deck deck = new Deck();
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();
        Hand table = new Hand();

         round = new Round(deck, player1Hand, player2Hand,table,0,0);
        round.setOnCardSelectedListener(this);  // Set the listener
        round.play();
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
        updateCardImage(findViewById(R.id.cardP1_4),player1Cards.get(3));

        updateCardImage(findViewById(R.id.cardP2_1),player2Cards.get(0));
        updateCardImage(findViewById(R.id.cardP2_2),player2Cards.get(1));
        updateCardImage(findViewById(R.id.cardP2_3),player2Cards.get(2));
        updateCardImage(findViewById(R.id.cardP2_4),player2Cards.get(3));
    }

}