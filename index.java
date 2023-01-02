package tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {

public Scanner scan = new Scanner(System.in);
	
	char store[][] = new char[3][3];
	char cross = 'X', circle = 'O', dot = '.';
	int row, column;
	int i;
	String player1, player2;
	String currentPlayer;	
	boolean flag;
	boolean samePlayers = false;
	String answer;
	
	
	void intialize() {
		
		flag = false;
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				store[x][y] = dot;
			}
		  }		
	}
	
	void takePlayersName() {
		
		System.out.print("Enter Player1 Name : ");
		player1 = scan.next();
		
		System.out.print("Enter Player2 Name : ");
		player2 = scan.next();
	}
	
	void whoFirst() {
		
		do {
			System.out.println("\nWho wants to play First? (" + player1 + " or "+player2+")");
			System.out.print("Answer : ");
			currentPlayer = scan.next();
						
			if(player1.equalsIgnoreCase(currentPlayer)) {
				break;
			}
			else if(player2.equalsIgnoreCase(currentPlayer)) {
                break;
			}		
			else {
				System.out.println(currentPlayer + " is not the registered player.");
			}
		} while(true);
	}
	
	void drawSlots() {
		
		System.out.println();
		for(int x=0; x<3; x++) {
			  for(int y=0; y<3; y++) {
			    System.out.print(store[x][y] + " ");
			 }
			System.out.println();
	    }
	}
	
	boolean isOccupied() {
		
		if(store[row][column] == 'X'  ||  store[row][column] == 'O') {
			System.out.println("Already Occupied! Choose row and column Again.");
			return true;
		}
		return false;
	}
	
	void setMark() {
		
		if (currentPlayer.equalsIgnoreCase(player1) ) {
			store[row][column] = cross;			
		}
		else {
			store[row][column] = circle;
		}
	}
	
	void chooseSlot() {
		
		do {
			System.out.print("\n" + currentPlayer+ " select Row(0-2) : ");
			row = scan.nextInt(); 
			
			if(row>2 || row<0) {
				System.out.println("You entered an invalid row.");
			}
		} while(row>2 || row<0);
		
		do {
			System.out.print(currentPlayer+ " select Column(0-2) : ");
			column = scan.nextInt(); 
			
			if(column>2 || column<0) {
				System.out.println("You entered an invalid column.\n");
			}
		} while(column>2 || column<0);
		
		if(isOccupied()) {
			chooseSlot();
		}
		else {
			setMark();
		}
	}
	
    void nextPlayer() {
		
	if(currentPlayer.equalsIgnoreCase(player1)) {
		currentPlayer = player2;
	}
	else  {
		currentPlayer = player1;
	 }
	}
    
     boolean checkCross() {
		
		if(store[0][0] == 'X' && store[0][1] == 'X' && store[0][2] == 'X') {
			return true;
		}
		else if(store[1][0] == 'X' && store[1][1] == 'X' && store[1][2] == 'X') {
			return true;
		}
		else if(store[2][0] == 'X' && store[2][1] == 'X' && store[2][2] == 'X') {
			return true;
		}
		else if(store[0][0] == 'X' && store[1][0] == 'X' && store[2][0] == 'X') {
			return true;
		}
		else if(store[0][1] == 'X' && store[1][1] == 'X' && store[2][1] == 'X') {
			return true;
		}
		else if(store[0][2] == 'X' && store[1][2] == 'X' && store[2][2] == 'X') {
			return true;
		}
		else if(store[0][0] == 'X' && store[1][1] == 'X' && store [2][2] == 'X') {
			return true;
		}
		else if(store[0][2] == 'X' && store[1][1] == 'X' && store [2][0] == 'X') {
			return true;
		}
		return false;
	}
     
     boolean checkCircle() {
     	     	
     	if(store[0][0] == 'O' && store[0][1] == 'O' && store[0][2] == 'O') {
 			return true;
 		}
 		else if(store[1][0] == 'O' && store[1][1] == 'O' && store[1][2] == 'O') {
 			return true;
 		}
 		else if(store[2][0] == 'O' && store[2][1] == 'O' && store[2][2] == 'O') {
 			return true;
 		}
 		else if(store[0][0] == 'O' && store[1][0] == 'O' && store[2][0] == 'O') {
 			return true;
 		}
 		else if(store[0][1] == 'O' && store[1][1] == 'O' && store[2][1] == 'O') {
 			return true;
 		}
 		else if(store[0][2] == 'O' && store[1][2] == 'O' && store[2][2] == 'O') {
 			return true;
 		}
 		else if(store[0][0] == 'O' && store[1][1] == 'O' && store [2][2] == 'O') {
 			return true;
 		}
 		else if(store[0][2] == 'O' && store[1][1] == 'O' && store [2][0] == 'O') {
 			return true;
 		}
 		return false;
     }
	
    void whoWins() {
    	
    	if(checkCross()) {
    		System.out.println("\n*** " + player1 + " Wins ***\n");
    		flag = true;
    	}
    	
    	if(checkCircle()) {
    		System.out.println("\n*** " + player2 + " Wins ***\n");
    		flag = true;
    	}
    }
    
    void utilityFunction() {
    	 
    	 intialize();
    	 
    	 if(samePlayers == false) {
    	 takePlayersName();
    	 }
    	 
    	 else {
    		 
    		 do { 
    		 System.out.println("\nWant to keep Players name same? (Y/N)");
    		 System.out.print("Answer : ");
    		 answer = scan.next();
    		 
    		  if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
    			  System.out.println("\nPlayer1 Name : " + player1);
    			  System.out.println("Player2 Name : " + player2);
    			  break;
    		  }
    		  else if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
    			  System.out.println();
    			  takePlayersName();
    			  break;
    		  }
    		  else {
    			  System.out.println(" "+ answer + " is not a valid answer.");
    		  }
    		 }while(true);
    	 }
    	 
    	 whoFirst();
    	 drawSlots();
    	
    	for(i=0;i<9;i++) {
    		
    		 chooseSlot();
    		 drawSlots();
    		 nextPlayer();
    		
    		if(i > 3) {
    			
    		 whoWins();
    		  if( flag == true) {
    			break;
   		  	  }
   		    }
    	}	
    	if(flag == false) {
    		System.out.println("\n*** Its a tie! ***\n");
    	}
    }
    
 public static void main(String[] args) {
		
	TicTacToe check = new TicTacToe();
	int switcher = 1;
	         
	do {	
		if(switcher == 1) {	
		check.utilityFunction();
		}
		
		System.out.println("\nWant to Play Again? (Y/N)");
		System.out.print("Answer : ");
		check.answer = check.scan.next();
		
		if( check.answer.equalsIgnoreCase("no") || check.answer.equalsIgnoreCase("n") ) {
			System.out.println("\nBye! See you later. :)");
			break;
		}
		else if(check.answer.equalsIgnoreCase("yes") || check.answer.equalsIgnoreCase("y")) {
			switcher = 1;
			check.samePlayers = true;
		}
		else {
			System.out.println(check.answer + " is not a valid answer.");
			switcher = 0;
		}	
	}while(true);	
   }	
}
