package org.tictac.view;

public class GameBoard {

	private char currentChar;

	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};
	
	public void setCurrentChar(PlayerType current) {
		this.currentChar = current == PlayerType.O ? 'O' : 'X';
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