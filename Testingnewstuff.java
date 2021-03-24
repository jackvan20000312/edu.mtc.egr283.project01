package edu.mtc.egr283.project01;

import java.util.HashSet;
import java.util.Set;

public class Testingnewstuff {
	static int TIECODE = -5;

	public static int finalVersion1_0_0(int numberofplayers,int[][] masterArray, int[] codeArray) {
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
			}else {return finalVersion1_0_0(numberofplayers, masterArray, codeArray);
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
	
}//ending of class testingnewstuff