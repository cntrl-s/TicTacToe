import java.util.Scanner;

import org.tictac.controller.GameController;
import org.tictac.model.GameModel;
import org.tictac.view.GameBoard;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GameModel play = new GameModel();
		GameBoard gameBoard = new GameBoard(scanner);
		GameController controller = new GameController(play, gameBoard);
		
		controller.start();
	}
}
