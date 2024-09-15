package com.example.cardr;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView cardP1_1, cardP1_2, cardP1_3, cardP1_4;
    private ImageView cardBot_1, cardBot_2, cardBot_3, cardBot_4;
    private ImageView playerCardOnTable1,playerCardOnTable2,playerCardOnTable3,playerCardOnTable4,playerCardOnTable5,playerCardOnTable6,playerCardOnTable7,playerCardOnTable8;
    private boolean isPlayer1Turn = true;

    private Hand player1Hand;
    private Hand botHand;
    private Round round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up card ImageViews
        cardP1_1 = findViewById(R.id.cardP1_1);
        cardP1_2 = findViewById(R.id.cardP1_2);
        cardP1_3 = findViewById(R.id.cardP1_3);
        cardP1_4 = findViewById(R.id.cardP1_4);

        cardBot_1 = findViewById(R.id.cardBot_1);
        cardBot_2 = findViewById(R.id.cardBot_2);
        cardBot_3 = findViewById(R.id.cardBot_3);
        cardBot_4 = findViewById(R.id.cardBot_4);

        playerCardOnTable1 = findViewById(R.id.player_card_on_table1);
        playerCardOnTable2 = findViewById(R.id.player_card_on_table2);
        playerCardOnTable3 = findViewById(R.id.player_card_on_table3);
        playerCardOnTable4 = findViewById(R.id.player_card_on_table4);
        // Find the start game button
        Button startGameButton = findViewById(R.id.start_game_button);

        startGameButton.setOnClickListener(v -> {
            startGameButton.setVisibility(View.GONE);  // Hide start button
            initializeGame();  // Start the game
        });
    }

    private void initializeGame() {
        Deck deck = new Deck();
        deck.shuffle();

        player1Hand = new Hand();
        botHand = new Hand();

        // Deal 4 cards to Player 1 and the Bot
        for (int i = 0; i < 4; i++) {
            player1Hand.add(deck.dealCard());
            botHand.add(deck.dealCard());
        }

        // Update UI to show Player 1's cards and Bot's placeholder
        updatePlayerHandUI(player1Hand, new ImageView[]{cardP1_1, cardP1_2, cardP1_3, cardP1_4});
        updateBotHandPlaceholder();

        // Player 1's turn starts
        setupCardClickListeners();
    }

    private void setupCardClickListeners() {

        cardP1_1.setOnClickListener(v -> handlePlayerCardClick(0));
        cardP1_2.setOnClickListener(v -> handlePlayerCardClick(1));
        cardP1_3.setOnClickListener(v -> handlePlayerCardClick(2));
        cardP1_4.setOnClickListener(v -> handlePlayerCardClick(3));
    }

    private void handlePlayerCardClick(int cardIndex) {
        if (isPlayer1Turn) {
            Card selectedCard = player1Hand.getCards().get(cardIndex);
            ImageView tableSpot = emptySpot();
            updateCardImage(emptySpot(), selectedCard);
            playCard(selectedCard);
            player1Hand.remove(selectedCard);
            refreshPlayerHandImages();

            // Bot's turn after Player 1
            isPlayer1Turn = false;
            botPlayCard();
        }
    }

    private void botPlayCard() {
        // Bot selects a random card
        Random random = new Random();
        int randomCardIndex = random.nextInt(botHand.getCards().size());
        Card botCard = botHand.getCards().get(randomCardIndex);
        ImageView tableSpot = emptySpot();
        updateCardImage(tableSpot, botCard);

        // Play the bot's card and remove it from the hand
        playCard(botCard);
        botHand.remove(botCard);

        // Refresh UI for Bot's card (optional)
        updateBotHandPlaceholder();

        // Switch back to Player 1's turn
        isPlayer1Turn = true;
        Toast.makeText(this, "Player 1's turn", Toast.LENGTH_SHORT).show();
    }

    private void playCard(Card card) {
        // Handle the logic when a card is played (e.g., update game state)
        Toast.makeText(this, "Card played: " + card.getSuit() + "_of_" + card.getRank(), Toast.LENGTH_SHORT).show();
    }

    private void updatePlayerHandUI(Hand hand, ImageView[] cardViews) {
        for (int i = 0; i < hand.getCards().size(); i++) {
            updateCardImage(cardViews[i], hand.getCards().get(i));
        }
    }

    private void updateBotHandPlaceholder() {
        ImageView[] botCardViews = {cardBot_1, cardBot_2, cardBot_3, cardBot_4};

        // Clear all bot's card views first
        for (ImageView botCardView : botCardViews) {
            botCardView.setImageResource(0); // Reset the ImageView
        }

        // Update only the remaining cards with the card back image
        for (int i = 0; i < botHand.getCards().size(); i++) {
            botCardViews[i].setImageResource(R.drawable.back_large);  // Show card back
        }

    }


    private void refreshPlayerHandImages() {
        cardP1_1.setImageResource(0);
        cardP1_2.setImageResource(0);
        cardP1_3.setImageResource(0);
        cardP1_4.setImageResource(0);

        updatePlayerHandUI(player1Hand, new ImageView[]{cardP1_1, cardP1_2, cardP1_3, cardP1_4});
    }

    private void updateCardImage(ImageView cardImageView, Card card) {
        // Example: Generate the drawable name based on card suit and rank
        String imageName = card.getSuit().toLowerCase() + "_of_" + card.getRank();
        int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
        cardImageView.setImageResource(imageResource);
    }
    private ImageView emptySpot(){
        // Check each player card spot on the table to find an empty one
        if (playerCardOnTable1.getDrawable() == null) {
            return playerCardOnTable1;
        } else if (playerCardOnTable2.getDrawable() == null) {
            return playerCardOnTable2;
        } else if (playerCardOnTable3.getDrawable() == null) {
            return playerCardOnTable3;
        } else if (playerCardOnTable4.getDrawable() == null) {
            return playerCardOnTable4;
        }
     else if (playerCardOnTable5.getDrawable() == null) {
        return playerCardOnTable5;
    }else if (playerCardOnTable6.getDrawable() == null) {
            return playerCardOnTable6;
        }else {
            Toast.makeText(this, "No empty spots left!", Toast.LENGTH_SHORT).show();
            return null; // No more spots
        }
    }
}
