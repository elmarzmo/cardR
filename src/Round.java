import java.util.ArrayList;

public class Round {
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private Hand table;
	private int player1Score;
	private int player2Score;
	boolean lastToEat = true;
	private ArrayList<Card> eatenCardPlayer1 = new ArrayList<>();
	private ArrayList<Card> eatenCardPlayer2 = new ArrayList<>();
	
	public Round(Deck deck, Hand player1Hand, Hand player2Hand, Hand table, int player1Score, int player2Score) {
			this.deck = deck;
			this.player1Hand= player1Hand;
			this.player2Hand = player2Hand;
			this.table = table;
			this.player1Score = player1Score;
			this.player2Score =  player2Score;
			
			
			
	}
	public void play() {
		for(int j =0; j<5; j++) {
			System.out.println("Round: "+(j+1));
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
	     System.out.println("Player 1 Score: "+ eatenCardPlayer1.size());
		 System.out.println("Player 2 Score: "+ eatenCardPlayer2.size());
		 if(j==4 && player1Hand.isEmpty() ) {
			 if(eatenCardPlayer2.isEmpty()) {
				 lastToEat =true; 
			 }
			if(lastToEat) {
				for(Card c:new ArrayList<>(table.getCards())) {
				eatenCardPlayer1.add( c);
				}
			}else if(!lastToEat) {
				for(Card c:new ArrayList<>(table.getCards())) {
					eatenCardPlayer2.add( c);
					}
			}
		 }
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
		

		
		
		if(playerNum == 1) {
		if(!eatenCardPlayer1.contains(cardToPlay)) {
			eatenCardPlayer1.add(cardToPlay);
			lastToEat = true;
			
		}
		if(!eatenCardPlayer1.contains(tableCard)) {
			eatenCardPlayer1.add(tableCard);
		}
		}
		else if(playerNum == 2) {
			if(!eatenCardPlayer2.contains(cardToPlay)) {
				eatenCardPlayer2.add(cardToPlay);
				lastToEat = false;
				
			}
			if(!eatenCardPlayer2.contains(tableCard)) {
				eatenCardPlayer2.add(tableCard);
			}
			}
		table.remove(tableCard);
		
		
		Card nextCard = table.getCard(tableCard.getRank()+1);
		
		if(nextCard != null && cardToPlay.getRank()+1==nextCard.getRank()) {
			
			rec( playerNum, nextCard,  nextCard);
			
		}
		
		}
	
	
	



	private void declareWinner() {
		System.out.println("End of the round!");
		System.out.println("Player 1 Score: "+ eatenCardPlayer1.size());
		System.out.println("Player 2 Score: "+ eatenCardPlayer2.size());
		
		if(eatenCardPlayer1.size() > eatenCardPlayer2.size()) {
			System.out.println("Player 1 wins!!");
		}else if(eatenCardPlayer2.size() > eatenCardPlayer1.size()) {
			System.out.println("Player 2 win!!");
		}
		else if(eatenCardPlayer1.size() == eatenCardPlayer2.size()) {
			System.out.println("it's a tie!");
		}
	}
}
