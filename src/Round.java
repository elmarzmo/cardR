
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
		 System.out.println("Player 1's hand: " + player1Hand);
	     System.out.println("Player 2's hand: " + player2Hand);
	     for(int i =0; i<4;i++) {
	    	table.add( player1Hand.chooseCard());
	    	table.add( player2Hand.chooseCard());
	     }
	     System.out.println("Player 1's hand: " + player1Hand);
	     System.out.println("table has: " + table);
	}

}
