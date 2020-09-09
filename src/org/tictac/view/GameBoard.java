package org.tictac.view;

import java.util.Scanner;

public class GameBoard {
	private Scanner scanner;

	private PlayerType currentChar;
	private PlayerType player;
	private PlayerType cpu;

	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};
	
	public GameBoard(Scanner scanner) {
		this.scanner = scanner;
		this.player = getPlayerChar();
		this.cpu = getCpuChar();
	}

	private PlayerType getPlayerChar() {
		while (true) {
			System.out.println("Type x or o");
			char playerChar = scanner.nextLine().toLowerCase().trim().charAt(0);

			if (playerChar == 'x') {
				return PlayerType.X;
			}
			
			if (playerChar == 'o') {
				return PlayerType.O;
			}
		}
	}
	
	private PlayerType getCpuChar() {
		return this.player == PlayerType.X ? PlayerType.O : PlayerType.X;
	}
	
	public void setCurrentChar(boolean cpuTurn) {
		this.currentChar = cpuTurn ? this.cpu : this.player;
	}

	public void printGameBoard() {
		System.out.println("Enter number b/w 1-9");

		for (char[] cs : gameBoard) {
			System.out.println(cs);
		}

		System.out.println();
	}

	public void markPosition(Integer currentPosition) {
		switch (currentPosition) {

		case 1: gameBoard[0][0] = this.currentChar.toString().charAt(0);
		break;
		case 2: gameBoard[0][2] = this.currentChar.toString().charAt(0);
		break;
		case 3: gameBoard[0][4] = this.currentChar.toString().charAt(0);
		break;
		case 4: gameBoard[2][0] = this.currentChar.toString().charAt(0);
		break;
		case 5: gameBoard[2][2] = this.currentChar.toString().charAt(0);
		break;
		case 6: gameBoard[2][4] = this.currentChar.toString().charAt(0);
		break;
		case 7: gameBoard[4][0] = this.currentChar.toString().charAt(0);
		break;
		case 8: gameBoard[4][2] = this.currentChar.toString().charAt(0);
		break;
		case 9: gameBoard[4][4] = this.currentChar.toString().charAt(0);
		break;

		default:
			break;
		}	
	}
}