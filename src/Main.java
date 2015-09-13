
public class Main {

	public static void main (String[]args){
		Game game = new Game();

		do{
			game.board.printBoard();
			if (game.checkStatus()){
				game.roundOfPlayX();
				game.checkForWinner();
				if (game.checkStatus()!=true){
					return;
				}
			}
			game.board.printBoard();
			if (game.checkStatus()){
				game.roundOfPlayOAI();
				game.checkForWinner();
				if (game.checkStatus()!=true){
					return;
				}
			}
		}while (game.checkStatus());

	}//ends main
}
