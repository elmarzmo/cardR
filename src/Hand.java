import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	private Suit suit;
	private Rank rank;
	
	//Constructor
	public Hand() {
		cards = new ArrayList<Card>();
	}
	public void clear() {
		cards.clear();
	}
	public void add(Card card) {
		cards.add(card);
	}
	public String showHand() {
		String str="";
		for(Card c:cards) {
			str +=c.toString();
		}
		return str;
	}

@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	for(Card c : cards) {
		sb.append(c.toString()).append(", ");
	}
	return sb.toString();
}
}
