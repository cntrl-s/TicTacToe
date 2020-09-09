package org.tictac.view;

import java.util.Scanner;

public class GameBoard {
	private Scanner scanner;

	private char currentChar = ' ';
	private final char playerChar;
	private final char cpuChar;

	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};
	
	public GameBoard(Scanner scanner) {
		this.scanner = scanner;
		this.playerChar = getPlayerChar();
		this.cpuChar = getCpuChar();
	}

	private char getPlayerChar() {
		while (true) {
			System.out.println("Type x or o");
			char playerChar = scanner.nextLine().toLowerCase().trim().charAt(0);
			if (playerChar == 'x' || playerChar == 'o')
				return playerChar;
		}
	}
	
	private char getCpuChar() {
		return this.playerChar == 'x' ? 'o' : 'x';
	}
	
	public void setCurrentChar(boolean cpuTurn) {
		this.currentChar = cpuTurn ? this.cpuChar : this.playerChar ;
	}

	public void displayGameBoard() {
		System.out.println("Enter number b/w 1-9");

		for (char[] cs : gameBoard) {
			System.out.println(cs);
		}

		System.out.println();
	}

	public void markPosition(Integer currentPosition) {
		switch (currentPosition) {

		case 1: gameBoard[0][0] = this.currentChar;
		break;
		case 2: gameBoard[0][2] = this.currentChar;
		break;
		case 3: gameBoard[0][4] = this.currentChar;
		break;
		case 4: gameBoard[2][0] = this.currentChar;
		break;
		case 5: gameBoard[2][2] = this.currentChar;
		break;
		case 6: gameBoard[2][4] = this.currentChar;
		break;
		case 7: gameBoard[4][0] = this.currentChar;
		break;
		case 8: gameBoard[4][2] = this.currentChar;
		break;
		case 9: gameBoard[4][4] = this.currentChar;
		break;

		default:
			break;
		}	
	}
}