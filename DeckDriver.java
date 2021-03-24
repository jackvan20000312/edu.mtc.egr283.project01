package edu.mtc.egr283.project01;

public class DeckDriver {

	public static void main(String[] args) {
		Deck d =  new Deck();
		
		do {
			System.out.println("Card #"+d.getNumberOfCardsRemaining() + ": " + d.deal().toString());
		}while(d.getNumberOfCardsRemaining()>0);
		
		Deck d2 = new Deck();
		d2.displayDeckSymbols();
		
		do {
			System.out.println("Card #"+d2.getNumberOfCardsRemaining() + ": " + d2.deal().toString());
		}while(d2.getNumberOfCardsRemaining()>0);
	}
	
}
