package org.foo.tictactoe;

import java.util.HashSet;
import java.util.Random;

public class TicTacToe {
	private static final int MIN_NUM_OF_MOVES = 5;
	HashSet<Integer> player1Moves = new HashSet<>();
	HashSet<Integer> computerMoves = new HashSet<>();
	private HashSet<Integer> allMoves = new HashSet<>();
	private final int[][] winningMoves = { 
			{1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, {3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9}
	};
	private char xOrO = ' ';
	private char[][] gameBoard = { 
			//1 ,  2 , 3 ,  4 ,  5
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
	};

	public void displayGameBoard() {
		System.out.println("Enter number b/w 1-9");
		for (char[] cs : gameBoard) {
			System.out.println(cs);
		}
		System.out.println();
	}

	public boolean makeMove(Integer currentPosition, boolean computerTurn) {
		if (allMoves.contains(currentPosition) || !currentPosition.toString().matches("[1-9]{1}")) {
			System.out.println("Invalid move");
			//go back static bool invalidMove
		} else {
			xOrO = computerTurn ? Main.COMP_X_OR_O : Main.PLAYER1_X_OR_O;
			setPositionOnBoard(currentPosition);
			allMoves.add(currentPosition);
			if (computerTurn) {
				computerMoves.add(currentPosition);
			} else {
				player1Moves.add(currentPosition);
			}
		}
		return checkWinner();
	}

	public void setPositionOnBoard (int currentPosition) {
		switch (currentPosition) {

		case 1: gameBoard[0][0] = xOrO;
		break;
		case 2: gameBoard[0][2] = xOrO;
		break;
		case 3: gameBoard[0][4] = xOrO;
		break;
		case 4: gameBoard[2][0] = xOrO;
		break;
		case 5: gameBoard[2][2] = xOrO;
		break;
		case 6: gameBoard[2][4] = xOrO;
		break;
		case 7: gameBoard[4][0] = xOrO;
		break;
		case 8: gameBoard[4][2] = xOrO;
		break;
		case 9: gameBoard[4][4] = xOrO;
		break;

		default:
			break;
		}	
	}

	public int generateComputerMove() {
		Random random = new Random();
		int computerCurMove = 0;
		while (true) {
			int generatedMove = random.nextInt(9) + 1;
			if (!allMoves.contains(generatedMove)) {
				computerCurMove = generatedMove;
				break;
			} 
		}
		return computerCurMove;
	}

	public boolean checkWinner() {
		if (allMoves.size() < MIN_NUM_OF_MOVES) {
			return true;
		}

		for (int i = 0; i < winningMoves.length; i++) {
			int player1MathcingMoveCount = 0;
			int computerMatchingMoveCount = 0;

			for (int j = 0; j < winningMoves[i].length ; j++) {
				if (player1Moves.contains(winningMoves[i][j])) {
					player1MathcingMoveCount++;
				}
				if (player1MathcingMoveCount == 3) {
					System.out.println("player1 wins");
					return false;
				}//player1

				if (computerMoves.contains(winningMoves[i][j])) {
					computerMatchingMoveCount++;
				}
				if (computerMatchingMoveCount == 3) {
					System.out.println("computer wins");
					return false;
				}//computer
			}
		}
		//to do tie
		return true;
	}
}