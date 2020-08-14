package org.foo.tictactoe;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static final char PLAYER1_X_OR_O = getPlayerChar();
	static final char COMP_X_OR_O = PLAYER1_X_OR_O == 'x' ? 'o' : 'x';

	private static char getPlayerChar() {
		char xOrO;
		while (true) {
			System.out.println("Type x or o");
			xOrO = scanner.nextLine().toLowerCase().trim().charAt(0);
			if (xOrO == 'x' || xOrO == 'o')
				break;
		}
		return xOrO;
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.displayGameBoard();

		while (true) {
			//handle numformatexcept
			int player1CurrentPosition = Integer.valueOf(scanner.nextLine());
			boolean keepPlaying = game.makeMove(player1CurrentPosition, false);
			game.displayGameBoard();
			if (!keepPlaying) return;
			int computerCurrentPosition = game.generateComputerMove();
			//to do stop after player1 wins (no error) debug to check
			keepPlaying = game.makeMove(computerCurrentPosition, true);
			game.displayGameBoard();
			if (!keepPlaying) return;
		}
	}
}