package edu.mtc.egr283.project01;

public class Hand {

	public PlayingCard[] cards;
	private int currentNumberOfCards;
	private static final String COMMA_SPACE = ". ";
	
	public Hand(int numberOfCardsToHold) {
		this.cards = new PlayingCard[numberOfCardsToHold];
		this.currentNumberOfCards = 0;
	}//end of constructor
	
	public void addACard(PlayingCard newPlayingCard) {
		this.cards[this.currentNumberOfCards++] = newPlayingCard;
	}//end of method addACard
	
	public void sort() {
		boolean isDescendingOrder = false;
		PlayingCard tempCard = null;
		
		do{
			isDescendingOrder = false;
			for(int i = 0; i < this.cards.length - 1; ++i) {
				if(this.cards[i].getRankValue() < this.cards[i + 1].getRankValue()) {
					tempCard = this.cards[i];
					this.cards[i] = this.cards[i + 1];
					this.cards[i+1] = tempCard;
					isDescendingOrder = true;
				}//end of if
			}//end of for loop
		}while(isDescendingOrder);
	}//end of method sort
	
	public boolean isRoyalFlush() {
		boolean rv = true;
		if(this.isAFlush()) {
			for(int i = 0; i < this.cards.length; ++i) {
				if(this.cards[i].getRankValue()<14-i) {
					rv = false;
					break;
				}// Ending bracket of if
			}// Ending bracket of for loop
		}else {
			rv=false;
		}return rv;
	}// Ending bracket of method isRoyalFlush
	
	public boolean isStraightFlush() {
		boolean rv = true;
		if(this.isAFlush()) {
			for(int i = 1; i < this.cards.length; ++i) {
				if(this.cards[i].getRankValue()!=cards[0].getRankValue()-i) {
					rv = false;
					break;
				}// Ending bracket of if
			}// Ending bracket of for loop
		}else {
			rv=false;
		}return rv;
	}// Ending bracket of method isStraightFlush
	
	
	public boolean isFourOfAKind() {
		boolean rv = false;
		int count=0;
		int current = cards[0].getRankValue();
		for (int i = 0; i < this.cards.length; i++) {
	        int next = cards[i].getRankValue();
	        if (current != next) {
	            current = next;
	           count = 1;
	        } else {
	            count++;
	            if (count == 4) {
	            	rv = true;
	            	break;
	            }// Ending bracket of if
	        }// Ending bracket of else
		}// Ending bracket of for loop	
		return rv;	
		}// Ending bracket of method isStraightFlush

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		for(PlayingCard oneCard:this.cards) {
			sb.append(oneCard.toString());
			sb.append(Hand.COMMA_SPACE);
		}//end of for loop
	return sb.toString();
	}//end of method tostring
	
	public String toStringSymbol() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.cards[0].toStringSymbol());
		for(int i =1; i<this.currentNumberOfCards; ++i) {
			sb.append(Hand.COMMA_SPACE);
			sb.append(this.cards[i].toStringSymbol());
		}//end of for loop
		return sb.toString();
	}//end of method tostringsymbol

	public boolean isFullHouse() {
		boolean rv = false;
		
		if(cards[0].getRankValue()==cards[1].getRankValue() && cards[2].getRankValue()==cards[3].getRankValue()&&cards[3].getRankValue()==cards[4].getRankValue()) {
			rv=true;
		}else if(cards[0].getRankValue()==cards[1].getRankValue() && cards[1].getRankValue()==cards[2].getRankValue()&&cards[3].getRankValue()==cards[4].getRankValue()) {
			rv=true;
		}else {
			rv=false;
		}// Ending bracket of else
		return rv;	
		}// Ending bracket of method isFullHouse
	
	public boolean isAFlush() {
		boolean rv = true;
		for(int i = 0; i < this.cards.length; ++i) {
			if(!this.cards[0].isSameSuit(this.cards[i])) {
				rv = false;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		return rv;
	}// Ending bracket of method isAFlush

	public boolean isStraight() {
		boolean rv = true;
		for(int i = 1; i < this.cards.length; ++i) {
			if(this.cards[i].getRankValue()!=cards[0].getRankValue()-i) {
				rv = false;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		return rv;
	}// Ending bracket of method isStraight
	
	public boolean isThreeOfAKind() {
		boolean rv = false;
		int count=0;
		int current = cards[0].getRankValue();
		for (int i = 0; i < this.cards.length; i++) {
	        int next = cards[i].getRankValue();
	        if (current != next) {
	            current = next;
	           count = 1;
	        } else {
	            count++;
	            if (count == 3) {
	            	rv = true;
	            	break;
	            }// Ending bracket of if
	        }// Ending bracket of else
		}// Ending bracket of for loop	
		return rv;	
		}// Ending bracket of method isThreeOfAKind
	
	public boolean isTwoPair() {
		boolean rv = false;
		if((cards[0].getRankValue()==cards[1].getRankValue()||cards[1].getRankValue()==cards[2].getRankValue()) && 
		   (cards[2].getRankValue()==cards[3].getRankValue()||cards[3].getRankValue()==cards[4].getRankValue())) {
			rv=true;
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method isTwoPair
	
	public boolean isOnePair() {
		boolean rv = false;
		for (int i = 1; i < this.cards.length; i++) {
	        if (cards[i-1].getRankValue() == cards[i].getRankValue()) {
	            rv=true;
	            break;
	        } else {
	            rv=false;
	        }// Ending bracket of else
		}// Ending bracket of for loop	
		return rv;	
		}// Ending bracket of method isOnePair
	
}
