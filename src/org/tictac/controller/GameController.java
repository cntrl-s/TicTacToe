package org.tictac.controller;

import java.util.Scanner;

import org.tictac.util.GameUtil;
import org.tictac.view.GameBoard;
import org.tictac.view.PlayerType;

public class GameController {
	private Scanner scanner;
	private GameUtil gameUtil;
	private GameBoard gameBoard;

	public GameController(Scanner scanner, GameUtil util, GameBoard gameBoard) {
		this.scanner = scanner;
		this.gameUtil = util;
		this.gameBoard = gameBoard;
	}
	
	private void init() {
		gameUtil.setPlayerChar();
		gameUtil.setCpuChar();

		gameBoard.printGameBoard();
	}
	
	public void start() {
		this.init();

		while (true) {
			//handle numformatexcept
			int player1Move = Integer.valueOf(scanner.nextLine());

			PlayerType player1 = gameUtil.getPlayer1();
			int gameStatus = gameUtil.makeMove(player1Move, player1);

			if (gameStatus == -1) {
				System.out.println("invalid move");
				continue;
			} 

			gameBoard.setCurrentChar(player1);
			gameBoard.markPosition(player1Move);
			gameBoard.printGameBoard();

			if (gameStatus == 0) {
				System.out.println("player 1 wins!");
				return;
			} 

			int cpuMove = gameUtil.generateCpuMove();
			PlayerType cpu = gameUtil.getCpu();

			gameStatus = gameUtil.makeMove(cpuMove, cpu);

			gameBoard.setCurrentChar(cpu);
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