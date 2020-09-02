import java.util.Scanner;

import org.game.controller.GameController;
import org.game.model.GameModel;
import org.game.view.GameView;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GameModel play = new GameModel();
		GameView gameBoard = new GameView(scanner);
		GameController controller = new GameController(play, gameBoard);
		
		controller.start();
	}
}
