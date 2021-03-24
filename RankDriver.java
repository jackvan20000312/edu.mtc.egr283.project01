package edu.mtc.egr283.project01;

public class RankDriver {

	public static void main(String[] args) {
		for(Rank r:Rank.values()) {
			System.out.println(r.getName()+" "+r.getSymbol());
		}
	}
}
