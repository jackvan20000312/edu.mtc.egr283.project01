package edu.mtc.egr283.project01;

public enum Suit {

	HEARTS("Hearts",'\u2665'), DIAMONDS("Diamonds",'\u2666'),CLUBS("Clubs",'\u2663'), SPADES("Spades",'\u2660');
	
	private final String suit;
	private final char symbol;
	
	private Suit(String newSuit, char newSymbol) {
		this.suit = newSuit;
		this.symbol=newSymbol;
	}//Ending bracket of constructor
	
	public String getSuit() {
		return this.suit;
	}//Ending bracket of method getSuit
	
	public char getSymbol() {
		return this.symbol;
	}//ending bracket of method getSYmbol
}//Ending bracket of enum suit