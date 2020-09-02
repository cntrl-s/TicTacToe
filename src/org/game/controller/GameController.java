package org.game.controller;

import java.util.Scanner;

import org.game.model.GameModel;
import org.game.view.GameView;

public class GameController {
	private Scanner scanner;
	private GameModel play;
	private GameView gameBoard;

	public GameController(GameModel play, GameView gameBoard) {
		this.play = play;
		this.gameBoard = gameBoard;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		gameBoard.displayGameBoard();

		while (true) {
			// move to view
			//handle numformatexcept
			int player1CurrentPosition = Integer.valueOf(scanner.nextLine());

			boolean cpuTurn = false;
			int gameStatus = play.makeMove(player1CurrentPosition, cpuTurn);

			if (gameStatus == 0) {
				System.out.println("player 1 wins!");
				return;
			} else if (gameStatus == -1) {
				System.out.println("invalid move");
				continue;
			} else {
				gameBoard.setPlayerChar(cpuTurn);
				gameBoard.showPositionOnBoard(player1CurrentPosition);
				gameBoard.displayGameBoard();
			}

			int cpuCurrentPosition = play.generateCpuMove();

			cpuTurn = true;
			gameStatus = play.makeMove(cpuCurrentPosition, cpuTurn);
			gameBoard.setPlayerChar(cpuTurn);
			gameBoard.showPositionOnBoard(cpuCurrentPosition);
			gameBoard.displayGameBoard();

			if (gameStatus == 0) {
				System.out.println("cpu wins!");
				return;
			}
		}
	}
}