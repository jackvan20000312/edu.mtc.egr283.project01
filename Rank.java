package edu.mtc.egr283.project01;

public enum Rank {

	DEUCE("Deuce",'2'), TREY("Trey",'3'), FOUR("Four",'4'),
	FIVE("Five",'5'), SIX("Six",'6'), SEVEN("Seven",'7'),
	EIGHT("Eight",'8'), NINE("Nine",'9'), TEN("Ten",'T'),
	JACK("Jack",'J'), QUEEN("Queen",'Q'), KING("King",'K'),
	ACE("Ace",'A');
	
	private final String name;
	private final char symbol;
	
	private Rank(String newName, char newSymbol) {
		
		this.name=newName;
		this.symbol=newSymbol;
	}//Ending bracket of constructor
	
	public String getName() {
		return this.name;
	}//Ending bracket of method getName
	
	public char getSymbol() {
		return this.symbol;
	}//ending bracket of method getSymbol
	
}//Ending Bracket of enum Rnak
