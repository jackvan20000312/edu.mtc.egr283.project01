package edu.mtc.egr283.project01;

public class PlayingCard {

	private final Rank rank;
	private final Suit suit;
	
	public PlayingCard(Rank newRank, Suit newSuit) {
		this.rank=newRank;
		this.suit=newSuit;
	}//Ending bracket of constructor
	
	public Rank getRank() {
		return this.rank;
	}//Ending bracket of method getRank
	
	public Suit getSuit() {
		return this.suit;
	}//Ending bracket of method getSuit
	
	public int getRankValue() {
		return this.rank.ordinal()+2;
	}//Ending bracket of method
	
	public boolean isSameRank(PlayingCard otherCard) {
		return (this.getRank()==otherCard.getRank());
	}//Ending bracket of method
	
	public boolean isSameSuit(PlayingCard otherCard) {
		return (this.getSuit()==otherCard.getSuit());
	}//Ending bracket of method
	
	
	@Override
	public String toString() {
		return this.rank.getName()+" of "+this.suit.getSuit();
	}//Ending Bracket of method toString
	
	public String toStringSymbol() {
		return this.rank.getSymbol() + "" + this.suit.getSymbol();
	}//Ending bracket of method toStringSymbol
	
}//Ending bracket of class PlayingCard
