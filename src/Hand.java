import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	
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

}
