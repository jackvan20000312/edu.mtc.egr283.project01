package edu.mtc.egr283.project01;

public class SuitDriver {

	
	public static void main(String[] args) {
//		
//
//		Suit c = Suit.CLUBS;
//		Suit h = Suit.HEARTS;
//		Suit d = Suit.DIAMONDS;
//		Suit s = Suit.SPADES;
//		System.out.println(c.getSuit()+" "+c.getSymbol());
//		System.out.println(h.getSuit()+" "+h.getSymbol());
//		System.out.println(d.getSuit()+" "+d.getSymbol());
//		System.out.println(s.getSuit()+" "+s.getSymbol());
//		
		for(Suit s1 : Suit.values()) {
			System.out.println(s1.getSuit()+" "+s1.getSymbol());
		}
	}
}
