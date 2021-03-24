package edu.mtc.egr283.project01;
import java.util.Random;
import javax.swing.JOptionPane;

//****************************************************************************************
//Author: Jacob Vaught       Modified: 1/20/2021     1/22/2021 WAS VERY LATE 12PM... sorry
//
//EGR-283  Project 01  			  Due: 1/20/2021
//****************************************************************************************
//This program is a mess. I would need to work on it for another half-week or so to fix it. 
//Can not even get it to repeat itself when user says yes. I have not added any extra features, 
//such as counting wins. i have not given the variables good names and i have not put enough comments.

//SCRATCH THAT, it "only" took ~16~ Hours.

public class Poker {
	static Player[] poker;
	static final int PLAYERNUMBER=4;
	static final int NUMBEROFCARDS=5;
	static int playersHandTypes[] = new int[4];
	static Deck deck= new Deck();
	static String goodBye = " ";
	
	public static void main(String[] args) {
		getPlayerNames();
		runProgram();
	}//ending bracket of method
	
	public static void getPlayerNames() {
		poker=new Player[PLAYERNUMBER];
		//gets player names
		for(int i=0; i<PLAYERNUMBER; ++i) {
			poker[i] = new Player(JOptionPane.showInputDialog("Please enter the player # "+(i+1)+"'s name."));
		}//ending bracket of  for loop
	}//ending bracket of method
	
	public static void runProgram() {
		PokerDeterminant.reset();
		for(int i = 0; i<PLAYERNUMBER; ++i) {
			for(int j = 0; j<NUMBEROFCARDS; ++j) {
				poker[i].addACardToHand(deck.deal());
			}//ending bracket of  for loop
			poker[i].getHand().sort();
			System.out.println("- "+poker[i].getName()+" -");
			System.out.println(poker[i].getHand().toStringSymbol());
			System.out.println(winningHandString(determineWinningHand(poker[i].getHand())));
			System.out.println();
			playersHandTypes[i]=determineWinningHand(poker[i].getHand());
		}//ending bracket of  for loop
		for(int i = 0; i<PLAYERNUMBER; ++i) {
		PokerDeterminant.startUpProcess(poker[i].getHand(), i);
		}//ending bracket of  for loop
		int wInNeR=PokerDeterminant.determineWinner();
		if(wInNeR!=PokerDeterminant.TIECODE) {
			System.out.println();
			System.out.println(poker[wInNeR].getName()+" is the winner.");
			System.out.println();
			System.out.println();
			poker[wInNeR].addAWin();
		} else {
			System.out.println("Darn. There was a Tie. Everyone loses? I really don't know. This only happens once during a blue moon.:)");
		} for(int i = 0; i<PLAYERNUMBER; ++i) {
			if(i!=wInNeR) {
				poker[i].addALoss();
			}//ending bracket of else
		}//ending bracket of  for loop
		doYouWantToContinue();
	}//ending bracket of method
	
	public static void doYouWantToContinue() {
		int continueOrNot = JOptionPane.showConfirmDialog(null, "Would you Like To Play Again?");
		if (continueOrNot==0) {
			deck = new Deck();
			for(int i = 0; i<PLAYERNUMBER; ++i) {
				poker[i].resetHand();
			}runProgram();
			//Continue program
		}else if (continueOrNot==1) {
			exitGameAndDisplayEachPlayersWinnings();
			//end program
		}else {
			JOptionPane.showMessageDialog(null,"Sorry, I Didn't quite catch that. Please press YES/NO. Could You Please try again?", "Error Occured", JOptionPane.ERROR_MESSAGE);
			doYouWantToContinue();
		}//ending bracket of else
	}//ending bracket of method
	
	public static String winningHandString(int winningHandNumberCode) {
		switch(winningHandNumberCode) {
		case -1:
			return "Error has occured in winningPlayerArrayLocation";
		case 0:
			return "High Card";
		case 1:
			return "One Pair";
		case 2:
			return "Two Pair";
		case 3:
			return "Three of a Kind";
		case 4:
			return "Straight";
		case 5:
			return "Flush";
		case 6:
			return "Full House";
		case 7:
			return "Four of a Kind";
		case 8:
			return "Straight Flush";
		case 9:
			return "Royal Flush";
		default:
			return "Error has occured";
		}//ending bracket of switch statement
	}//ending bracket of method
	
	public static int determineWinningHand(Hand hand) {	
		if(hand.isRoyalFlush()) {
			return 9;
		}else if(hand.isStraightFlush()) {
			return 8;
		}else if(hand.isFourOfAKind()) {
			return 7;
		}else if(hand.isFullHouse()) {
			return 6;
		}else if(hand.isAFlush()) {
			return 5;
		}else if(hand.isStraight()) {
			return 4;
		}else if(hand.isThreeOfAKind()) {
			return 3;
		}else if(hand.isTwoPair()) {
			return 2;
		}else if(hand.isOnePair()) {
			return 1;
		}else {
			return 0;
		}// Ending bracket of else
	}// Ending bracket of whatIsTheWinningHand

	public static void exitGameAndDisplayEachPlayersWinnings() {
		System.out.println("Sorry to see you go.:(");
		for(int i = 0; i<PLAYERNUMBER; ++i) {
			System.out.println(poker[i].getName()+" won "+poker[i].getWins()+" times, but lost "+poker[i].getLosses()+" times.");
			System.out.println();
		}//ending bracket of  for loop
		pickRandomGoodByeMessage();
		System.out.println(goodBye);
	}//ending bracket of method
	
	public static void pickRandomGoodByeMessage() {
		Random randomizer= new Random();
		switch(randomizer.nextInt(2)+1) {
		case 1:
			goodBye="MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
					"MMMMMMMMMMMMMMMWX0Okxddddxkk00KXWMMMMMMMMMMMMMMMMMMMMMWX0OxxdddxkO0XNMMMMMMMMMMMMMMMMMMMMMMMMMMMMNK0kxxdddxkO0XWMMMMMMMMMMMMMMMWXKKKKKKKKKKKKKKKKKKXXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXKKKKKKKKKKKKKKKKKKKKKKXXWMMMMMMMMMMMWXKKKKKKKKKKKKKKXWMMMMMMMNKKKKKKKKKKKNMWXKKKKKKKKKKKKKKKKKKKKKKKKKKKKNMMMMMMM\r\n" + 
					"MMMMMMMMMMMNOoc,..           ...,cOMMMMMMMMMMMMMMMN0dc,..         ..,:oONMMMMMMMMMMMMMMMMMMMMNOo:'..         ..,cd0WMMMMMMMMMMMNo....................'',;cox0NMMMMMMMMMMMMMMMMMMMMMMMMMMMXl........................';cokXWMMMMM0:.............'oNMMMMMMMO;.........'dNXl............................oWMMMMMM\r\n" + 
					"MMMMMMMMW0l'      ':oxkkxo:.      oWMMMMMMMMMMMWXd,.    .;ldkkxo;.      ,oKMMMMMMMMMMMMMMMW0o'     .:oxkkdl,.     .;xXMMMMMMMMMMXOc.        .:cccc;'.       .'ckXMMMMMMMMMMMMMMMMMMMMMMMMWXk:         .:ccccc:,.        .c0WMMMWXx'          ,kNMMMMMMMMWKl.     .cONWWXk:.        .cccccccc;.      lNMMMMMM\r\n" + 
					"MMMMMMW0c.      ,xNMMMMMMMWKc.    oWMMMMMMMMMMNd.      ;OWMMMMMMW0:       .dNMMMMMMMMMMMMKl.     .cKWMMMMMMNk,       ,kWMMMMMMMMMMX:        :NMMMMWNKxo:.       'oKMMMMMMMMMMMMMMMMMMMMMMMMMK,        lWMMMMMMWXk;        .xWMMMMMK:         cNMMMMMMMMMMMO.    ,OWMMMMMMK;        lWMMMMMMMWKl.    lNMMMMMM\r\n" + 
					"MMMMMNx.       lXMMMMMMMMMMMNl    oWMMMMMMMMMK:       cXMMMMMMMMMMNo.       cXMMMMMMMMMWO,      .dWMMMMMMMMMMX:       .dNMMMMMMMMMNc        :NMMMMMMMMMW0:.       'xNMMMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMXc        ,0MMMMMMK:        .xWMMMMMMMMMNl    :KMMMMMMMMX:        lWMMMMMMMMMNo.   lNMMMMMM\r\n" + 
					"MMMMNd.       cNMMMMMMMMMMMMMXo;;:kWMMMMMMMMK;       ;XMMMMMMMMMMMMX:        lNMMMMMMMWO'       lNMMMMMMMMMMMM0,       .dWMMMMMMMMWl        :NMMMMMMMMMMMNd.       .oNMMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMk.       .kMMMMMMMK;        .kWMMMMMMMWd.   cXMMMMMMMMMX:        lWMMMMMMMMMMXo;;;kWMMMMMM\r\n" + 
					"MMMWx.       ,0MMMMMMMMMMMMMMMMMMMMMMMMMMMMXc       .xWMMMMMMMMMMMMMk.       .xWMMMMMMK,       .OMMMMMMMMMMMMMWd.       '0MMMMMMMMWl        :NMMMMMMMMMMMMNl        .xWMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMk.       ,KMMMMMMMMK;        'OMMMMMMNd.   lXMMMMMMMMMMX:        lWMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
					"MMMK,        oWMMMMMMMMMMMMMMMMMMMMMMMMMMMMk.       '0MMMMMMMMMMMMMMX;        :XMMMMMWo        :XMMMMMMMMMMMMMMO'        lNMMMMMMMWl        :NMMMMMMMMMMMMMK,        ;XMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMNl       .xWMMMMMMMMMK;        ,0MMMMWd.  .oNMMMMMMMMMMMX:        lWMMMMMW0ddkNMMMMMMMMMMMM\r\n" + 
					"MMWx.       .kMMMMMMMMMMMMMMMMMMMMMMMMMMMMNc        :XMMMMMMMMMMMMMMWo        .OMMMMMX;        lWMMMMMMMMMMMMMMX:        ;KMMMMMMMWl        :NMMMMMMMMMMMMMWo        .kMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMWKl.      ;OWMMMMMMMMMMM0,        ;KMMWd.  .oNMMMMMMMMMMMMX:        lWMMMMMK,  'OMMMMMMMMMMMM\r\n" + 
					"MMNl        ,0MMMMMMMMMMMMMMMMMMMMMMMMMMMMK,        cNMMMMMMMMMMMMMMMd.       .xMMMMMO.        dWMMMMMMMMMMMMMMWc        .OMMMMMMMWl        :NMMMMMMMMMMMMMMx.        dMMMMMMMMMMMMMMMMMMMMMX:        ;OOOOOOko:.     'ckNMMMMMMMMMMMMMM0,        :XNd.  .dNMMMMMMMMMMMMMX:        ;kOOOOd,   'OMMMMMMMMMMMM\r\n" + 
					"MMX:        ;KMMMMMMMMMMMMMMMMMMMMMMMMMMMMO'        lWMMMMMMMMMMMMMMMx.       .dMMMMMx.       .dMMMMMMMMMMMMMMMWl        .OMMMMMMMWl        :NMMMMMMMMMMMMMMk.        oWMMMMMMMMMMMMMMMMMMMMX:                      'oKWMMMMMMMMMMMMMMMMWO'        :l.  .xWMMMMMMMMMMMMMMX:                   'OMMMMMMMMMMMM\r\n" + 
					"MMX:        ;KMMMMMMMMXOkkkkkkkkkkkkk0NMMMO.        lWMMMMMMMMMMMMMMMx.       .dMMMMMx.       .dMMMMMMMMMMMMMMMWl        .OMMMMMMMWl        :NMMMMMMMMMMMMMMk.        oWMMMMMMMMMMMMMMMMMMMMX:        'looooll;'     .'ckXMMMMMMMMMMMMMMMWO'           .xWMMMMMMMMMMMMMMMX:        'loool;.   .OMMMMMMMMMMMM\r\n" + 
					"MMN:        ,KMMMMMMMM0;.           .cKMMM0'        cNMMMMMMMMMMMMMMMx.       .xMMMMMk.        dWMMMMMMMMMMMMMMWl        '0MMMMMMMWl        :NMMMMMMMMMMMMMMx.       .xMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMNO:.      'xNMMMMMMMMMMMMMMWk.         .kWMMMMMMMMMMMMMMMMX:        lWMMMMWx.  'OMMMMMMMMMMMM\r\n" + 
					"MMWl        '0MMMMMMMMWNO;         ;ONMMMMK;        :XMMMMMMMMMMMMMMWd        '0MMMMMO'        lWMMMMMMMMMMMMMMNc        ;XMMMMMMMWl        :NMMMMMMMMMMMMMWo        '0MMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMNo.      .lXMMMMMMMMMMMMMMWd.       .xWMMMMMMMMMMMMMMMMMX:        lWMMMMMWk:;oKMMMMMMMMMMMM\r\n" + 
					"MMWx.       .kMMMMMMMMMMMk.       .kMMMMMMWl        '0MMMMMMMMMMMMMMNl        cNMMMMMX:        :XMMMMMMMMMMMMMMX;        oWMMMMMMMWl        :NMMMMMMMMMMMMMX:        cNMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMK;       .xWMMMMMMMMMMMMMMk.       .OMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
					"MMMK,        lWMMMMMMMMMMO.       .OMMMMMMMO.       .dWMMMMMMMMMMMMMK;       .kMMMMMMWd.       .OMMMMMMMMMMMMMMO.       ,0MMMMMMMMWl        :NMMMMMMMMMMMMWk.       ,0MMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMX:        lWMMMMMMMMMMMMMMk.       .OMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMMN000KWMMMMMM\r\n" + 
					"MMMWx.       'OMMMMMMMMMMO.       .OMMMMMMMNo        ;KMMMMMMMMMMMMWd.      .oNMMMMMMMX:        lNMMMMMMMMMMMMNl       .xWMMMMMMMMWl        :NMMMMMMMMMMMW0,       'OWMMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMX;        oWMMMMMMMMMMMMMMk.       .OMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMMNl. .:XMMMMMM\r\n" + 
					"MMMMNo.       :XMMMMMMMMMk.       .OMMMMMMMMXc        lNMMMMMMMMMMWO'      .oNMMMMMMMMMK;       .dWMMMMMMMMMMWx.      .xWMMMMMMMMMNc        :NMMMMMMMMMMWO,       ;0WMMMMMMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMWx.       '0MMMMMMMMMMMMMMMk.       .OMMMMMMMMMMMMMMMMMMX:        lWMMMMMMMMMWx.   :XMMMMMM\r\n" + 
					"MMMMMNx.       :KMMMMMMMNc        .OMMMMMMMMMNo.       cKWMMMMMMMNx'      'xNMMMMMMMMMMMKc.      .oXMMMMMMMMXo.      ,OWMMMMMMMMMMN:        :NMMMMMMMNKOc.      ,xNMMMMMMMMMMMMMMMMMMMMMMMMMK;        lWMMMMMMMWXo.       'kWMMMMMMMMMMMMMMMx.       .kMMMMMMMMMMMMMMMMMMX;        lWMMMMMMMMNd.    cNMMMMMM\r\n" + 
					"MMMMMMW0c.      .lkKXK0x;         .OMMMMMMMMMMW0c.      .lx0XXKOd;.     'oXMMMMMMMMMMMMMMNk;.      'okKXXKOo,      ,xNMMMMMMMMMMWXd.        'dkkkxdl:'.      .ckNMMMMMMMMMMMMMMMMMMMMMMMMMWXo.        ,dxxxxxdl;.       .lKWMMMMMMMMMMMMMMN0;         ;0WMMMMMMMMMMMMMMWXd.        ,dxxxxxxdl,      lWMMMMMM\r\n" + 
					"MMMMMMMMWKd:'.     ....   .';.    'OMMMMMMMMMMMMWKd:'.     ....     .,lkXMMMMMMMMMMMMMMMMMMW0o;..     ....    ..;oONMMMMMMMMMMMNo.                  ....';cdOXWMMMMMMMMMMMMMMMMMMMMMMMMMMXl.                      ..';lkXWMMMMMMMMMMMMMMNd'.           .,xNMMMMMMMMMMMXl.                           oWMMMMMM\r\n" + 
					"MMMMMMMMMMMWN0kdolc:::cldk0NWXdloxONMMMMMMMMMMMMMMMWN0kdolc:::ccldxOXWMMMMMMMMMMMMMMMMMMMMMMMMWX0kdolc:::ccodk0XWMMMMMMMMMMMMMMNOxxxxxxxxxxxxxxxxkkO0KKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOxxxxxxxxxxxxxxxxxxxxxkOKXNMMMMMMMMMMMMMMMMMMMW0xxxxxxxxxxxxxxx0WMMMMMMMMMMMNOxxxxxxxxxxxxxxxxxxxxxxxxxxxkKMMMMMMM\r\n" + 
					"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
			break;
		case 2:
			goodBye=
			"        GGGGGGGGGGGGG          OOOOOOOOO               OOOOOOOOO          DDDDDDDDDDDDD                       BBBBBBBBBBBBBBBBB        YYYYYYY       YYYYYYY     EEEEEEEEEEEEEEEEEEEEEE\r\n" + 
			"     GGG::::::::::::G        OO:::::::::OO           OO:::::::::OO        D::::::::::::DDD                    B::::::::::::::::B       Y:::::Y       Y:::::Y     E::::::::::::::::::::E\r\n" + 
			"   GG:::::::::::::::G      OO:::::::::::::OO       OO:::::::::::::OO      D:::::::::::::::DD                  B::::::BBBBBB:::::B      Y:::::Y       Y:::::Y     E::::::::::::::::::::E\r\n" + 
			"  G:::::GGGGGGGG::::G     O:::::::OOO:::::::O     O:::::::OOO:::::::O     DDD:::::DDDDD:::::D                 BB:::::B     B:::::B     Y::::::Y     Y::::::Y     EE::::::EEEEEEEEE::::E\r\n" + 
			" G:::::G       GGGGGG     O::::::O   O::::::O     O::::::O   O::::::O       D:::::D    D:::::D                  B::::B     B:::::B     YYY:::::Y   Y:::::YYY       E:::::E       EEEEEE\r\n" + 
			"G:::::G                   O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B::::B     B:::::B        Y:::::Y Y:::::Y          E:::::E             \r\n" + 
			"G:::::G                   O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B::::BBBBBB:::::B          Y:::::Y:::::Y           E::::::EEEEEEEEEE   \r\n" + 
			"G:::::G    GGGGGGGGGG     O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B:::::::::::::BB            Y:::::::::Y            E:::::::::::::::E   \r\n" + 
			"G:::::G    G::::::::G     O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B::::BBBBBB:::::B            Y:::::::Y             E:::::::::::::::E   \r\n" + 
			"G:::::G    GGGGG::::G     O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B::::B     B:::::B            Y:::::Y              E::::::EEEEEEEEEE   \r\n" + 
			"G:::::G        G::::G     O:::::O     O:::::O     O:::::O     O:::::O       D:::::D     D:::::D                 B::::B     B:::::B            Y:::::Y              E:::::E             \r\n" + 
			" G:::::G       G::::G     O::::::O   O::::::O     O::::::O   O::::::O       D:::::D    D:::::D                  B::::B     B:::::B            Y:::::Y              E:::::E       EEEEEE\r\n" + 
			"  G:::::GGGGGGGG::::G     O:::::::OOO:::::::O     O:::::::OOO:::::::O     DDD:::::DDDDD:::::D                 BB:::::BBBBBB::::::B            Y:::::Y            EE::::::EEEEEEEE:::::E\r\n" + 
			"   GG:::::::::::::::G      OO:::::::::::::OO       OO:::::::::::::OO      D:::::::::::::::DD                  B:::::::::::::::::B          YYYY:::::YYYY         E::::::::::::::::::::E\r\n" + 
			"     GGG::::::GGG:::G        OO:::::::::OO           OO:::::::::OO        D::::::::::::DDD                    B::::::::::::::::B           Y:::::::::::Y         E::::::::::::::::::::E\r\n" + 
			"        GGGGGG   GGGG          OOOOOOOOO               OOOOOOOOO          DDDDDDDDDDDDD                       BBBBBBBBBBBBBBBBB            YYYYYYYYYYYYY         EEEEEEEEEEEEEEEEEEEEEE";

			break;
		default:
			goodBye= "Good Bye";
				
		}//end of switch statement
	}//ending bracket of a method (useless Goodbye message)
	
}// Ending bracket of Poker Class
