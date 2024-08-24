import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards;
	//Constructor
	public Deck() {
		cards = new ArrayList<Card>();
		
		for(Suit suit : Suit.values()) {
			for(Rank rank: Rank.values()) {
				cards.add(new Card(rank,suit));
			}
		}
	}
	//randomize the order of the cards
	public void shuffle() {
		Collections.shuffle(cards);
	}
	//deal the card from the deck
	// remove the first card after it been return
	public Card dealCard() {
		return cards.remove(0);
	}

}
