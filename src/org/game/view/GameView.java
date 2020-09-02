package org.game.view;

import java.util.Scanner;

public class GameView {
	private Scanner scanner;

	private char xOrO = ' ';
	private char playerChar;
	private char cpuChar;

	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};
	
	public GameView(Scanner scanner) {
		this.scanner = scanner;
		this.playerChar = getPlayerChar();
		this.cpuChar = getCpuChar();
	}
	
	private char getCpuChar() {
		return playerChar == 'x' ? 'o' : 'x';
	}

	private char getPlayerChar() {
		while (true) {
			System.out.println("Type x or o");
			char xOrO = scanner.nextLine().toLowerCase().trim().charAt(0);
			if (xOrO == 'x' || xOrO == 'o')
				return xOrO;
		}
	}
	
	public void setPlayerChar(boolean playerTurn) {
		this.xOrO = playerTurn ? this.playerChar : this.cpuChar;
	}

	public void displayGameBoard() {
		System.out.println("Enter number b/w 1-9");
		for (char[] cs : gameBoard) {
			System.out.println(cs);
		}
		System.out.println();
	}

	public void showPositionOnBoard(Integer currentPosition) {
		switch (currentPosition) {

		case 1: gameBoard[0][0] = this.xOrO;
		break;
		case 2: gameBoard[0][2] = this.xOrO;
		break;
		case 3: gameBoard[0][4] = this.xOrO;
		break;
		case 4: gameBoard[2][0] = this.xOrO;
		break;
		case 5: gameBoard[2][2] = this.xOrO;
		break;
		case 6: gameBoard[2][4] = this.xOrO;
		break;
		case 7: gameBoard[4][0] = this.xOrO;
		break;
		case 8: gameBoard[4][2] = this.xOrO;
		break;
		case 9: gameBoard[4][4] = this.xOrO;
		break;

		default:
			break;
		}	
	}
}