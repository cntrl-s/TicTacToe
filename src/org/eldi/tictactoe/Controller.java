package org.eldi.tictactoe;

import java.util.Scanner;

public class Controller {
	private Scanner scanner;
	private GameUtil gameUtil;
	private GameBoard gameBoard;

	public Controller(Scanner scanner, GameUtil util, GameBoard gameBoard) {
		this.scanner = scanner;
		this.gameUtil = util;
		this.gameBoard = gameBoard;
	}
	
	private void init() {
		gameUtil.setPlayerType();
		gameUtil.setCpuChar();

		gameBoard.printGameBoard();
	}
	
	public void start() {
		this.init();

		while (true) {
			//TODO handle numformatexcept
			int player1Move = Integer.valueOf(scanner.nextLine());

			PlayerType player1 = gameUtil.getPlayer1();
			int gameStatus = gameUtil.makeMove(player1Move, player1);

			if (gameStatus == GameUtil.INVALID_MOVE) {
				System.out.println("invalid move");
				continue;
			} 

			gameBoard.setCurrentChar(player1);
			gameBoard.markPosition(player1Move);
			gameBoard.printGameBoard();

			if (gameStatus == GameUtil.PLAYER_WINS) {
				System.out.println("player 1 wins!");
				return;
			} else if (gameStatus == GameUtil.NOBODY_WINS)  {
				System.out.println("Nobody wins!");
				return;
			}

			int cpuMove = gameUtil.generateCpuMove();
			PlayerType cpu = gameUtil.getCpu();

			gameStatus = gameUtil.makeMove(cpuMove, cpu);

			gameBoard.setCurrentChar(cpu);
			gameBoard.markPosition(cpuMove);
			gameBoard.printGameBoard();

			if (gameStatus == GameUtil.PLAYER_WINS) {
				gameBoard.printGameBoard();
				System.out.println("cpu wins!");
				return;
			} else if (gameStatus == GameUtil.NOBODY_WINS) {
				System.out.println("Nobody wins!");
				return;
			}
		}
	}
}
