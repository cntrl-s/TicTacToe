package org.eldi.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GameBoard gameBoard = new GameBoard();
		GameUtil gameUtil = new GameUtil(scanner);
		Controller controller = new Controller(scanner, gameUtil, gameBoard);
		
		controller.start();
	}
}
