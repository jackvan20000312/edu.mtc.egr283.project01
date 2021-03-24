package edu.mtc.egr283.project01;

public class HandDriver {

	public static void main(String[] args) {
//		int x =4;
//		Deck d = new Deck();
//		Hand[] hand;
//		hand= new Hand[x];
//		for(int i = 0; i<x; ++i) {
//			hand[i] = new Hand(13);
//		}
//		do {
//			for(int i = 0; i<x; ++i) {
//				hand[i].addACard(d.deal());
//			}
//		}while(d.getNumberOfCardsRemaining()>0);
//		for(int i = 0; i<x; ++i) {
//			System.out.println(hand[i].toStringSymbol());
//		}
		boolean x;
		do {
		Deck d2 = new Deck();
		Hand h = new Hand(5);
			for(int i = 0; i<5; ++i) {
				h.addACard(d2.deal());
			}

		h.sort();
		
		System.out.println(h.toStringSymbol());
//		for(int i = 0; i<5; ++i) {
//			System.out.print(h.cards[i].getRankValue()+". ");
//		}
		x=h.isTwoPair();
		System.out.println();
		System.out.println(h.isTwoPair());
		}while(!x);
		//System.out.println(h.toStringSymbol());
//		Deck d3 = new Deck();
//		Hand h = new Hand(3);
//		for(int i = 0; i < 3; ++i) {
//		h.addACard(d3.deal());
//		}// Ending bracket of for loop
		//System.out.println(h.toStringSymbol());
		//System.out.println(h.isAFlush());

	}
	
}
