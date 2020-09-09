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
		gameBoard.printGameBoard();

		while (true) {
			//handle numformatexcept
			int player1Move = Integer.valueOf(scanner.nextLine());

			boolean cpuTurn = false;
			int gameStatus = play.makeMove(player1Move, cpuTurn);

			if (gameStatus == -1) {
				System.out.println("invalid move");
				continue;
			} 

			gameBoard.setCurrentChar(cpuTurn);
			gameBoard.markPosition(player1Move);
			gameBoard.printGameBoard();

			if (gameStatus == 0) {
				System.out.println("player 1 wins!");
				return;
			} 

			int cpuMove = play.generateCpuMove();

			cpuTurn = true;
			gameStatus = play.makeMove(cpuMove, cpuTurn);

			gameBoard.setCurrentChar(cpuTurn);
			gameBoard.markPosition(cpuMove);
			gameBoard.printGameBoard();

			if (gameStatus == 0) {
				gameBoard.printGameBoard();
				System.out.println("cpu wins!");
				return;
			}
		}
	}
}