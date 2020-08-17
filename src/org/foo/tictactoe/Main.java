package org.foo.tictactoe;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static final char PLAYER1_CHAR = getPlayerChar();
	static final char CPU_CHAR = PLAYER1_CHAR == 'x' ? 'o' : 'x';

	private static char getPlayerChar() {
		while (true) {
			System.out.println("Type x or o");
			char xOrO = scanner.nextLine().toLowerCase().trim().charAt(0);
			if (xOrO == 'x' || xOrO == 'o')
				return xOrO;
		}
	}

	public static void main(String[] args) {
		GamePlay play = new GamePlay();
		GameUI gameBoard = play.getGameBoard();
		gameBoard.displayGameBoard();

		while (true) {
			//handle numformatexcept
			int player1CurrentPosition = Integer.valueOf(scanner.nextLine());
			int gameStatus = play.makeMove(player1CurrentPosition, false);
			gameBoard.displayGameBoard();
			if (gameStatus == 0) {
				System.out.println("player 1 wins!");
				return;
			} else if (gameStatus == -1) {
				System.out.println("invalid move");
				continue;
			}

			int cpuCurrentPosition = play.generateCpuMove();
			gameStatus = play.makeMove(cpuCurrentPosition, true);
			gameBoard.displayGameBoard();
			if (gameStatus == 0) {
				System.out.println("cpu wins!");
				return;
			}
		}
	}
}