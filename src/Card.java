
public class Card {
//private fields
	private Suit suit;
	private Rank rank;
 
// Constructor methods
	public Card(Rank rank, Suit suit ) {
		this.rank = rank;
		this.suit = suit;
	
	}
	public String getSuit() {
		return suit.getSuit();
	}

	public int getRank() {
		return rank.getRank();
	}
	
	
	@Override
	public String toString() {
		String str= rank.getRank() +" of " +suit.getSuit();
		return str;
	}


}
