package com.example.cardr;

import java.util.Objects;

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
		String str= rank.getRank() +"_of_" +suit.getSuit();
		return str;
	}
	@Override
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
		Card card = (Card) obj;
		return rank == card.rank && suit == card.suit;
	}
	@Override
	public int hashCode(){
		return Objects.hash(suit,rank);
	}

}
