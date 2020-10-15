package org.tictac.controller;

import java.util.Scanner;

import org.tictac.util.GameUtil;
import org.tictac.view.GameBoard;

public class GameController {
	private Scanner scanner;
	private GameUtil gameUtil;
	private GameBoard gameBoard;

	public GameController(Scanner scanner, GameUtil util, GameBoard gameBoard) {
		this.scanner = scanner;
		this.gameUtil = util;
		this.gameBoard = gameBoard;
	}
	
	public void start() {
		gameBoard.printGameBoard();

		while (true) {
			//handle numformatexcept
			int player1Move = Integer.valueOf(scanner.nextLine());

			boolean cpuTurn = false;
			int gameStatus = gameUtil.makeMove(player1Move, cpuTurn);

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

			int cpuMove = gameUtil.generateCpuMove();

			cpuTurn = true;
			gameStatus = gameUtil.makeMove(cpuMove, cpuTurn);

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