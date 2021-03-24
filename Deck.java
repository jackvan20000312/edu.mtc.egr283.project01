package edu.mtc.egr283.project01;

import java.util.Random;

public class Deck {

	private static PlayingCard[] cards;
	private static Random randomizer;
	private static int numberOfCardsRemaining;
	
	public static final int DECK_SIZE = 52;
	
	public Deck() {
		int arrayIndex = 0;
		Deck.cards = new PlayingCard[Deck.DECK_SIZE];
		Deck.numberOfCardsRemaining = Deck.DECK_SIZE;
		Deck.randomizer = new Random();
		
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				Deck.cards[arrayIndex++] = new PlayingCard(r, s);
			}//end of INNER for loop - RANK
		}//end of OUTER for loop - SUIT
	}//end of constructor
	
	public PlayingCard deal() {
		PlayingCard rv = null;
		int index = -1;
		
		do {
			index = Deck.randomizer.nextInt(Deck.DECK_SIZE);
			rv = Deck.cards[index];
		} while(rv == null);
		--Deck.numberOfCardsRemaining;
		Deck.cards[index] = null;
		return rv;
	}//end of method deal
	
	public int getNumberOfCardsRemaining() {
		return Deck.numberOfCardsRemaining;
	}//end of method getNumberOfCardsRemaining
	
	public void displayDeck() {
		for(PlayingCard pc : Deck.cards) {
			System.out.println(pc.toString());
		}//end of for loop 
	}//end of method displayDeck

	public void displayDeckSymbols() {
		for(PlayingCard pc : Deck.cards) {
			System.out.println(pc.toStringSymbol());
		}//end of for loop
	}//end of method displayDecSymbols
}//end of class Deck