
public class Round {
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private Hand table;
	private int player1Score;
	private int player2Score;
	
	public Round(Deck deck, Hand player1Hand, Hand player2Hand, Hand table, int player1Score, int player2Score) {
			this.deck = deck;
			this.player1Hand= player1Hand;
			this.player2Hand = player2Hand;
			this.table = table;
			this.player1Score = player1Score;
			this.player2Score = player2Score;
	}
	public void play() {
		
		for(int i=0; i<4; i++) {
			player1Hand.add(deck.dealCard());
			player2Hand.add(deck.dealCard());
		}
		
	     for(int i =0; i<4;i++) {
	    	 
	     }
	}
	private void playCard(Hand playerHand, int playerNum) {

		Card cardToPlay = playerHand.chooseCard();
		//Remove the card from the players hand
		playerHand.remove(cardToPlay);
		
		//check if the card can eat any cards on the table
		for(Card tableCard : new ArrayList<>(table.getCards())) {
			if(cardToPlay.getRank()==tableCard.getRank()) {
			rec(playerNum, cardToPlay, tableCard);
			}
		}
		
	}
	private void rec(int playerNum, Card cardToPlay, Card tableCard) {
		increaseScore(playerNum);
		table.remove(tableCard);
		if(cardToPlay.getRank()+1==tableCard.getRank()) {
			rec( playerNum,  cardToPlay,  tableCard);
		}
		
		}
	}
	
	private void increaseScore(int playerNumber,int points) {
		if(playerNumber == 1) {
			player1Score+=points;
		}else if(playerNumber ==2){
			player2Score+=points;
		}
	}

}
