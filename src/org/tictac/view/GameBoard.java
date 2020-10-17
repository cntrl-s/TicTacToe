package org.tictac.view;

public class GameBoard {

	private PlayerType currentChar;

	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};
	
	public void setCurrentChar(PlayerType current) {
		this.currentChar = current == PlayerType.O ? PlayerType.X : PlayerType.O;
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