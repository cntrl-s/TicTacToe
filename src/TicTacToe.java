import java.util.Scanner;

import org.tictac.controller.GameController;
import org.tictac.util.GameUtil;
import org.tictac.view.GameBoard;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GameBoard gameBoard = new GameBoard();
		GameUtil gameUtil = new GameUtil(scanner);
		GameController controller = new GameController(scanner, gameUtil, gameBoard);
		
		controller.init();
		controller.start();
	}
}
