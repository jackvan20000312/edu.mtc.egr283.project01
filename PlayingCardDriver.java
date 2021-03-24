package edu.mtc.egr283.project01;

public class PlayingCardDriver {

	public static void main(String[] args) {
		for(Suit s: Suit.values()) {
			
			for(Rank r: Rank.values()) {
				PlayingCard pc = new PlayingCard(r, s);
				System.out.print(pc.getRankValue() + " ");
				System.out.println(pc.toStringSymbol()+" "+pc.toString());
			}
		}
		
		PlayingCard pc1 = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
		PlayingCard pc2 = new PlayingCard(Rank.NINE, Suit.CLUBS);
		PlayingCard pc3 = new PlayingCard(Rank.DEUCE, Suit.DIAMONDS);
		
		System.out.println("9 vs. 9: "+pc1.isSameRank(pc2));
		System.out.println("9 vs. 2: "+pc1.isSameRank(pc3));
		
		System.out.println("D vs. C: "+pc1.isSameSuit(pc2));
		System.out.println("D vs. D: "+pc1.isSameSuit(pc3));
	}
	
}
