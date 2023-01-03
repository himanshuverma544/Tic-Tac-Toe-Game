import java.util.Scanner;

class Main
{
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
    		
    		if(store[row][column] == cross  ||  store[row][column] == circle) {
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
        
        boolean checkForSymbol(char symbol) {
             
            for(int round=1; round <= 2; round++) {
                for(row=0, column=0; row < 3; row++) {
                    
                    switch(round) {
                        case 1 : 
                            if(store[row][column] == symbol && store[row][column+1] == symbol  && store[row][column+2] == symbol) {
                                return true;   
                            }
                            break;
                            
                        case 2 :
                           if(store[column][row] == symbol && store[column+1][row] == symbol  && store[column+2][row] == symbol) {
                                return true;   
                            }
                            break;
                    }
                }
            }
    	    
    	    // Round 3
    	    
    	    if(store[0][0] == symbol && store[1][1] == symbol && store[2][2] == symbol) {
    			return true;
    		}
    		else if(store[0][2] == symbol && store[1][1] == symbol && store [2][0] == symbol) {
    			return true;
    		}
    		
    		return false;
    	}
    	
        void whoWins() {
        	
        	if(checkForSymbol('X')) {
        		System.out.println("\n*** " + player1 + " Wins ***\n");
        		flag = true;
        	}
        	
        	if(checkForSymbol('O')) {
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
        		System.out.println("\n*** It's a tie! ***\n");
        	}
        }
        
    public static void main(String[] args) {
    		
    	Main main = new Main();
    	int switcher = 1;
    	         
    	do {	
    		if(switcher == 1) {	
    		main.utilityFunction();
    		}
    		
    		System.out.println("\nWant to Play Again? (Y/N)");
    		System.out.print("Answer : ");
    		main.answer = main.scan.next();
    		
    		if( main.answer.equalsIgnoreCase("no") || main.answer.equalsIgnoreCase("n") ) {
    			System.out.println("\nBye! See you later.");
    			break;
    		}
    		else if(main.answer.equalsIgnoreCase("yes") || main.answer.equalsIgnoreCase("y")) {
    			switcher = 1;
    			main.samePlayers = true;
    		}
    		else {
    			System.out.println(main.answer + " is not a valid answer.");
    			switcher = 0;
    		}	
    	} while(true);	
    }	
}
