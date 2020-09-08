import java.util.Scanner;

import org.game.controller.GameController;
import org.game.model.GameModel;
import org.game.view.GameBoard;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GameModel play = new GameModel();
		GameBoard gameBoard = new GameBoard(scanner);
		GameController controller = new GameController(play, gameBoard);
		
		controller.start();
	}
}
