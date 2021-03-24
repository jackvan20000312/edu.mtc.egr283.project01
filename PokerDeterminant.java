package edu.mtc.egr283.project01;

import java.util.HashSet;//finding duplicates
import java.util.Set;//finding duplicates
public class PokerDeterminant {
	static final int PLAYERNUMBER=4;
	static final int NUMBEROFCARDS=5;
	public static final int TIECODE=-5;
	static int current=TIECODE;
	static int currentHigh=-1;
	static int masterArray[][]= {{-1,-1,-1,-1},
										{0,0,0,0},
										{0,0,0,0},
										{0,0,0,0},
										{0,0,0,0},
										{0,0,0,0}};

	public static void startUpProcess(Hand hand, int iNt) {
		masterArray[0][iNt]=Poker.determineWinningHand(hand);
		for(int i=1; i<6; i++) {
			masterArray[i][iNt]=hand.cards[i-1].getRankValue();
		}//testing below
		determines_highestnumberinFirstTypeArray(0);
	}//ending bracket of method

	public static int determineWinner() {
		int[] arraySequential = {1,2,3,4,5,0};
		int[] array00 = {0,0,0,0,0,0};
		int[] array315 = {3,1,5,2,4,0};
		switch(currentHigh) {
		case 9:
			//Royal Flush
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array00);
		case 8:
			//Straight Flush
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array00);
		case 7:			
			//Four of a Kind
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array315);
		case 6:
			//Full House
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array315);
		case 5:
			//flush
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, arraySequential);
		case 4:
			//Straight
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array00);
		case 3:
			//Three of a Kind
			int[] array3 = {3,1,2,4,5,0};//these are special sequences
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array3);
		case 2:
			//Two Pair
			int[] array2 = {2,4,1,3,5,0};//these are special sequences
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, array2);
		case 1:
			//One Pair
			return onePair(PLAYERNUMBER, masterArray, arraySequential);
		case 0:
			//High Card	
			return givenCodeCalculateWinningHand(PLAYERNUMBER,masterArray, arraySequential);
		default:
			return TIECODE;
		}//end of switch 
	}//ending bracket of method
	
	public static int givenCodeCalculateWinningHand(int numberofplayers,int[][] masterArray, int[] codeArray) {
		//takes an array that tells this how to determine winning hand, example 12345 would say check 1st card, 2nd card, etc, etc. but 31542 would say check 3rd card, then 1st, etc, etc.
		boolean rv;
		int[] tempArray;
		rv=areThereOtherNumbersEqualToThis(findHighestNumberInAnArray(masterArray[0]), masterArray[0]);
		if(rv) {
			rv=false;
			tempArray=getsNumberFromLocationArrayAndReturnsRowArray(codeArray[0], numberofplayers, findHighestNumberandReturnArrayWithTheirLocation(masterArray[0]), masterArray);
			rv = areThereOtherNumbersEqualToThis(findHighestNumberInAnArray(tempArray),tempArray);
			if(rv) {
				for(int i=0; i<5; i++) {
					rv=false;
					tempArray=getsNumberFromLocationArrayAndReturnsRowArray(codeArray[i+1], numberofplayers, findHighestNumberandReturnArrayWithTheirLocation(tempArray), masterArray);
					rv = areThereOtherNumbersEqualToThis(findHighestNumberInAnArray(tempArray),tempArray);
					if(!rv) {return findHighestNumberandReturnArrayWithTheirLocation(tempArray)[0];
					}// Ending bracket of else
				}return TIECODE;
			}else {return findHighestNumberandReturnArrayWithTheirLocation(tempArray)[0];
			}// Ending bracket of else	
		}else {return findHighestNumberandReturnArrayWithTheirLocation(masterArray[0])[0];
		}// Ending bracket of else
	}// Ending bracket of method
		
	public static void determines_highestnumberinFirstTypeArray(int iNt) {
		for(int i =0; i<masterArray[iNt].length; i++) {
			current=masterArray[iNt][i];
			if(current>currentHigh) {
				currentHigh=current;
			}//ending bracket of if statement
		}//ending bracket of  for loop
	}//ending bracket of method

	public static void reset() {
		for(int i=0; i<masterArray[0].length; i++) {
			masterArray[0][i]=-1;
		}for(int i=1; i<masterArray.length; i++) {
			for(int j=0; j<masterArray[i].length; j++) {
				masterArray[i][j]=0;
			}//ending bracket of for loop
		}//ending bracket of for loop
		current=TIECODE;
		currentHigh=-1;
	}//ending bracket of method
	
	public static int onePair(int numberofplayers, int[][] masterArray, int[] codeArray) {
		boolean rv;
		int[] tempArray;
		rv=areThereOtherNumbersEqualToThis(findHighestNumberInAnArray(masterArray[0]), masterArray[0]);
		if(rv) {
			tempArray=findHighestNumberandReturnArrayWithTheirLocation(masterArray[0]);
			tempArray=getsLocationArrayandReturnsduplicateRowArray(tempArray, masterArray);
			tempArray=findHighestNumberandReturnArrayWithTheirLocation(tempArray);
			if(tempArray.length==1) {
				return tempArray[0];
			}else {return givenCodeCalculateWinningHand(numberofplayers, masterArray, codeArray);
			}//end bracket of else
		}else {return findHighestNumberandReturnArrayWithTheirLocation(masterArray[0])[0];
		}//end bracket of else
	}// Ending bracket of method
	
	public static int[] getsLocationArrayandReturnsduplicateRowArray(int[] locationArray, int[][] masterArray) {
		int index=0;
		int[] returnArray=new int[4];
		for(int i=0; i<4; i++) {
			if (index<locationArray.length) {
				if(i==locationArray[index]) {
					returnArray[i]=findDuplicates(getsNumberAndReturnsColumnArray(i, masterArray));
					index++;
				}//end bracket of if statement
			}else {returnArray[i]=0;
			}//end bracket of else
		}return returnArray;
	}// Ending bracket of method
	
	public static int[] getsNumberAndReturnsColumnArray(int columnNumber, int[][] masterArray) {
		int[] returnArray= new int[masterArray.length-1];
		for(int i = 1; i<masterArray.length; i++) {
			returnArray[i-1]=masterArray[i][columnNumber];
		}//end bracket of for loop
		return returnArray;
	}//end bracket of method
	
	public static int[] getsNumberFromLocationArrayAndReturnsRowArray(int masterArray_cardlevel, int numberofplayers, int[] locationArray, int[][] masterArray) {
		int index = 0;
		int[] returnArray= new int[numberofplayers];
		for(int i = 0; i<numberofplayers; i++) {
			if (index<locationArray.length) {
				if(locationArray[index]==i) {
					returnArray[i]=masterArray[masterArray_cardlevel][i];
					index++;
				}//end bracket of if statement 
			}else {returnArray[i]=0;
			}//end bracket of else
		}return returnArray;
	}//end bracket of method
	
	public static int[] findHighestNumberandReturnArrayWithTheirLocation(int[] array) {
		return whereAreTheseNumbersLocated(findHighestNumberInAnArray(array), array);
	}// Ending bracket of method
	
	public static int[] whereAreTheseNumbersLocated(int checkingThisNumber, int[] array) {
		int[] returnThisArray;
		int howManyDuplicates=0;
		for(int index = 0; index < array.length; index++) {
            if( checkingThisNumber == array[index] ) {
            	howManyDuplicates++;	
            }//end bracket of if statement
        }returnThisArray= new int[howManyDuplicates];
        int returnThisArrayCurrentLocation=0;
        for(int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
        	if( checkingThisNumber == array[arrayIndex] ) {
        		returnThisArray[returnThisArrayCurrentLocation]=arrayIndex;	
        		returnThisArrayCurrentLocation++;
        	}//end bracket of if statement
        }return returnThisArray;
	}// Ending bracket of method
	
	public static int findDuplicates(int[] array) { 
		Set<Integer> store = new HashSet<>(); 
		for (int iNt : array) { 
			if (store.add(iNt) == false) { 
				return iNt; 
			}//end bracket of if statement 
		}return -2;
	}// Ending bracket of method
	
	public static boolean areThereOtherNumbersEqualToThis(int checkingThisNumber, int[] array) {
		int number=0;
		for(int index = 0; index < array.length; index++) {
            if(checkingThisNumber == array[index] ) { number++;
            }//end bracket of if statement
		} if (number>=2) {return true;
		}//end bracket of if statement
		return false;
	}//ending bracket of method
	
	public static int findHighestNumberInAnArray(int[] array) {
		int largest = Integer.MIN_VALUE;
        int index = 0;
        while( index < array.length ) {
            if( largest < array[index] ) {
                largest = array[index];
            }index++;
        } return largest;
	}//ending bracket of method

}//end of class