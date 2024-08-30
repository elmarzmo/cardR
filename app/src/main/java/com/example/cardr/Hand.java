package com.example.cardr;

import java.util.ArrayList;
import java.util.Scanner;

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
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	public void remove(Card card) {
		cards.remove(card);
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public String showHand() {
		String str="";
		for(Card c:cards) {
			str +=c.toString();
		}
		return str;
	}
	public Card getCard(int Rank) {
	
		for(Card card: cards) {
			if(card.getRank()== Rank) {
				return card;
			}
		}
		return null;
	}
	
	public Card chooseCard() {
		Scanner scanner = new Scanner(System.in);
		 while(true) {
			 
			 System.out.println("Choose a card from your hand:");
			 String chosenCard = scanner.nextLine();
			  //fine the card in hand
			 for(Card c :cards) {
				 if(c.toString().equalsIgnoreCase(chosenCard)) {
					 cards.remove(c);
				 return c;
				 }
			 }
			  // If the card is not found, notify the user and let them try again
	            System.out.println("Invalid choice. Please choose a card from your hand.");
	            scanner.close();
		 }
		 
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
