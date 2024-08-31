package com.example.cardr;

public enum Suit {
COINS("coins"),
CUPS("cups"),
CLUBS("clubs"),
SWORDS("swords");
	
	private final String suitText;
	
	//Constructor
	private Suit(String suitText) {
		this.suitText = suitText;
	}
	
	// Public Method
	public String getSuit() {
		return suitText;
	}
}
