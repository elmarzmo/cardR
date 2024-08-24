
public class Game {
	// Attributes
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private Hand table;
	private int score;
	
	public Game() {
		deck = new Deck();
		player1Hand = new Hand();
		player2Hand = new Hand();
		deck.shuffle();
		table = new Hand();
	}
	public void start() {
		for(int i=0; i<4; i++) {
			player1Hand.add(deck.dealCard());
			player2Hand.add(deck.dealCard());
		}
		 System.out.println("Player 1's hand: " + player1Hand);
	     System.out.println("Player 2's hand: " + player2Hand);
	     for(int i =0; i<1;i++) {
	    	table.add( player1Hand.chooseCard());
	    	 
	     }
	     System.out.println("Player 1's hand: " + player1Hand);
	     System.out.println("table has: " + table);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		game.start();
	}

}
