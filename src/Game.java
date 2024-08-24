
public class Game {
	// Attributes
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private int score;
	
	public Game() {
		deck = new Deck();
		player1Hand = new Hand();
		player2Hand = new Hand();
		deck.shuffle();
	}
	public void start() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
	}

}
