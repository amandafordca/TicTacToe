import java.util.Random;
import java.util.Scanner;


public class Game {

	public boolean noWinner = true;
	Board board = new Board();
	Scanner input = new Scanner(System.in);

	public void roundOfPlayX(){
		System.out.println("Enter the coordinate you would like to place an X on.\n");
		String selection;
		do{
			selection = input.nextLine();
			if (checkInvalidMove(selection)){
				System.out.println("Please enter a coordinate that hasn't already been selected.\n");
			}	
		}while(checkInvalidMove(selection));

		for (int x=0;x<3;x++){
			for (int y=0; y<3; y++){
				if (board.getValue(x,y).equals(selection)){
					board.setValue(x,y,"X ");
				}//ends if
			}//ends nested for
		}//ends for
	}//ends roundOfPlayX method

	public void roundOfPlayOAI(){
		Random random = new Random();
		String selection = "";
		do{ 
			int number = random.nextInt(9)+1;
			switch (number){

			case 1:
				selection = "a1";
				break;
			case 2:
				selection = "a2";
				break;
			case 3:
				selection = "a3";
				break;
			case 4:
				selection = "b1";
				break;
			case 5:
				selection = "b2";
				break;
			case 6:
				selection = "b3";
				break;
			case 7:
				selection = "c1";
				break;
			case 8:
				selection = "c2";
				break;
			case 9:
				selection = "c3";
				break;
			}

			if (checkInvalidMove(selection)){
			}	
		}while(checkInvalidMove(selection));

		for (int x=0;x<3;x++){
			for (int y=0; y<3; y++){
				if (board.getValue(x,y).equals(selection)){
					board.setValue(x,y,"O ");
				}//ends if
			}//ends nested for
		}//ends for

		System.out.println("Player O has placed an O on "+selection+".");
	}//ends roundOfPlayO method

	public void checkForWinner(){

		/**check horizontal rows*/
		for (int y = 0; y < 3; ++y) {
			if (board.getValue(0, y).equals(board.getValue(1, y))&& board.getValue(1, y).equals(board.getValue(2, y))){
				noWinner=false;
				board.printBoard();
				System.out.println("\nPlayer "+board.getValue(0, y)+"has won!");
			}
		}
		/**check vertical rows*/
		for (int x = 0; x < 3; ++x) {
			if (board.getValue(x, 0).equals(board.getValue(x, 1))&& board.getValue(x, 1).equals(board.getValue(x, 2))){
				noWinner=false;
				board.printBoard();
				System.out.println("\nPlayer "+board.getValue(x, 0)+"has won!");
			}
		}

		/**check diagonal */

		if (board.getValue(0, 0).equals(board.getValue(1,1))&& board.getValue(1,1).equals(board.getValue(2,2))){
			noWinner=false;
			board.printBoard();
			System.out.println("\nPlayer "+board.getValue(0, 0)+"has won!");
		}

		if (board.getValue(0,2).equals(board.getValue(1,1))&& board.getValue(1,1).equals(board.getValue(2,0))){
			noWinner=false;
			board.printBoard();
			System.out.println("\nPlayer "+board.getValue(1, 1)+"has won!");
		}

		/**check for draw*/
		if(this.checkForDraw()){
			noWinner=false;
			board.printBoard();
			System.out.println("\nThere is no winner! Game is a draw!");
		}

	}//ends checkForWinner method

	public boolean checkForDraw(){
		boolean isDraw=true;
		for(int x=0; x<3 ; x++){
			for(int y=0; y<3 ; y++){
				if (!board.getValue(x,y).equals("X ")|| !board.getValue(x,y).equals("O ")){
					isDraw=false; 
				}
			}//exits inner for
		}//exits outer for
			if(isDraw){ return true; }
			else{ return false; }
		

	}

	public boolean checkStatus(){
		return noWinner;
	}

	public boolean checkInvalidMove(String coordinateName){
		boolean validMove=true;
		for(int x=0; x<3 ; x++){
			for(int y=0; y<3 ; y++){
				//System.out.println(board.getValue(x, y)+"*");
				if (board.getValue(x,y).equals(coordinateName)){
					return false;
				}
				else {
					validMove=false;

				}//exits else
			}//exits inner for
		}//exits outer for
		if (validMove==false){
			return true;
		}
		return true;
	}//ends checkInvalidMove
} //ends Game class
