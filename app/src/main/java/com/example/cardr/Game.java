package com.example.cardr;

public class Game {
	// Attributes
	private Deck deck;
	private Hand player1Hand;
	private Hand player2Hand;
	private Hand table;
	private int player1Score;
	private int player2Score;
	
	public Game() {
		deck = new Deck();
		player1Hand = new Hand();
		player2Hand = new Hand();
		deck.shuffle();
		table = new Hand();
	}
	public void start() {
		
		Round round1 = new Round(deck, player1Hand, player2Hand, table, player1Score, player2Score);
		round1.play();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		game.start();
	}

}
