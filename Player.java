package edu.mtc.egr283.project01;

public class Player {

	private String name;
	private Hand hand;
	private int wins;
	private int losses;
	
	public Player(String newName) {
		this(newName, 5);
	}// Ending bracket of constructor
	
	public Player(String newName, int numberOfCardsInHand) {
		this.setName(newName);
		this.setHand(new Hand(numberOfCardsInHand));
		this.setWins(0);
		this.setLosses(0);
		}// Ending bracket of constructor
	
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	public String getName() {
		return this.name;
	}// Ending bracket of method getName

	public void resetHand() {
		this.setHand(new Hand(5));
	}// Ending bracket of method resetHand
	
	private void setHand(Hand newHand) {
		this.hand = newHand;
	}// Ending bracket of method setHand

	public Hand getHand() {
		return this.hand;
	}// Ending bracket of method getHand

	public void addACardToHand(PlayingCard newCard) {
		this.getHand().addACard(newCard);
	}// Ending bracket of method addACardToHand

	private void setWins(int newNumberOfWins) {
		this.wins = newNumberOfWins;
	}// Ending bracket of method setwins
		
	public void addAWin() {
		this.setWins(this.getWins()+1);
	}// Ending bracket of method addAWin
	
	public int getWins() {
		return this.wins;
	}// Ending bracket of method getwins
		
	private void setLosses(int newNumberOfLosses) {
		this.losses = newNumberOfLosses;
	}// Ending bracket of method setLosses
		
	public void addALoss() {
		this.setLosses(this.getLosses()+1);
	}// Ending bracket of method addALoss
	
	public int getLosses() {
		return this.losses;
	}// Ending bracket of method getLosses


}
