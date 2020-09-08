package org.tictac.controller;

import java.util.Scanner;

import org.tictac.model.GameModel;
import org.tictac.view.GameBoard;

public class GameController {
	private Scanner scanner;
	private GameModel play;
	private GameBoard gameBoard;

	public GameController(GameModel play, GameBoard gameBoard) {
		this.play = play;
		this.gameBoard = gameBoard;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		gameBoard.displayGameBoard();

		while (true) {
			//handle numformatexcept
			int player1Move = Integer.valueOf(scanner.nextLine());

			boolean cpuTurn = false;
			int gameStatus = play.makeMove(player1Move, cpuTurn);

			if (gameStatus == 0) {
				gameBoard.setPlayerChar(cpuTurn);
				gameBoard.showPositionOnBoard(player1Move);
				gameBoard.displayGameBoard();
				System.out.println("player 1 wins!");
				return;
			} else if (gameStatus == -1) {
				System.out.println("invalid move");
				continue;
			} else {
				gameBoard.setPlayerChar(cpuTurn);
				gameBoard.showPositionOnBoard(player1Move);
				gameBoard.displayGameBoard();
			}

			int cpuMove = play.generateCpuMove();

			cpuTurn = true;
			gameStatus = play.makeMove(cpuMove, cpuTurn);
			gameBoard.setPlayerChar(cpuTurn);
			gameBoard.showPositionOnBoard(cpuMove);
			gameBoard.displayGameBoard();

			if (gameStatus == 0) {
				gameBoard.displayGameBoard();
				System.out.println("cpu wins!");
				return;
			}
		}
	}
}