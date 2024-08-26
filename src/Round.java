import java.util.ArrayList;

public class Round {
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private Hand table;
	private int player1Score;
	private int player2Score;
	private int points;
	public Round(Deck deck, Hand player1Hand, Hand player2Hand, Hand table, int player1Score, int player2Score) {
			this.deck = deck;
			this.player1Hand= player1Hand;
			this.player2Hand = player2Hand;
			this.table = table;
			this.player1Score = 0;
			this.player2Score = 0;
			this.points =0;
	}
	public void play() {

		for(int i=0; i<4; i++) {
			player1Hand.add(deck.dealCard());
			player2Hand.add(deck.dealCard());
		}
		
	     while(!player1Hand.isEmpty() || !player2Hand.isEmpty()) {
	    	 playTurn(player1Hand, 1);
	    	 if(player2Hand.isEmpty()) {
	    		 break;
	    	 }
	    	 playTurn(player2Hand,2);
	     }
	     declareWinner();
	}
	private void playTurn(Hand playerHand, int playerNum) {

		System.out.println("Player "+ playerNum + "'s turn. Your hand: "+ playerHand);
		System.out.println("Current table: "+ table);
		Card cardToPlay = playerHand.chooseCard();
		//Remove the card from the players hand
		playerHand.remove(cardToPlay);
		boolean matchFound =false;
		
	
		//check if the card can eat any cards on the table
		
		for(Card tableCard : new ArrayList<>(table.getCards())) {
			if(cardToPlay.getRank()==tableCard.getRank()) {
				
			rec(playerNum, cardToPlay, tableCard);
			matchFound = true;
			}
				
			
				
			
		}
		if(!matchFound) {
		table.add(cardToPlay);
		}
	}
	private void rec(int playerNum, Card cardToPlay, Card tableCard) {
		

		ArrayList<Card> cardsToEat = new ArrayList<>();
		
		increaseScore(playerNum, cardsToEat);
		if(!cardsToEat.contains(cardToPlay)) {
			cardsToEat.add(cardToPlay);
		}
	//	cardsToEat.add(tableCard);
		
		table.remove(tableCard);
		
		
		
		if(cardToPlay.getRank()+1==tableCard.getRank()) {
			
			rec( playerNum, table.getCard(cardToPlay.getRank()+1),  tableCard);
			
		}
		
		}
	
	
	private void increaseScore(int playerNumber,ArrayList<Card> points) {
		if(playerNumber == 1) {
			player1Score+=points.size();
		}else if(playerNumber ==2){
			player2Score+=points.size();
		}
	}



	private void declareWinner() {
		System.out.println("End of the round!");
		System.out.println("Player 1 Score: "+ player1Score);
		System.out.println("Player 2 Score: "+ player2Score);
		
		if(player1Score > player2Score) {
			System.out.println("Player 1 wins!!");
		}else if(player2Score > player1Score) {
			System.out.println("Player 2 win!!");
		}
		else if(player1Score == player2Score) {
			System.out.println("it's a tie!");
		}
	}
}
