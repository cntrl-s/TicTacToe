package org.foo.tictactoe;

public class GameUI {
	private char xOrO = ' ';
	private char[][] gameBoard = { 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};

	public void setPlayerChar(char xOrO) {
		this.xOrO = xOrO;
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