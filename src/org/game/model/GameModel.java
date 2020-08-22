package org.game.model;

import java.util.HashSet;
import java.util.Random;

import org.game.controller.GameController;
import org.game.view.GameView;

public class GameModel {
	private final int[][] winningMoves = { 
			{1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, {3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9}
	};
	private HashSet<Integer> player1Moves = new HashSet<>();
	private HashSet<Integer> cpuMoves = new HashSet<>();
	private HashSet<Integer> allMoves = new HashSet<>();
	private GameView gameBoard = new GameView();

	public GameView getGameBoard() {
		return gameBoard;
	}

	public int makeMove(Integer currentPosition, boolean cpuTurn) {
		if (allMoves.contains(currentPosition) || !currentPosition.toString().matches("[1-9]{1}")) {
			return -1;
		} else {
			gameBoard.setPlayerChar(cpuTurn ? GameController.CPU_CHAR : GameController.PLAYER1_CHAR);
			gameBoard.showPositionOnBoard(currentPosition);
			allMoves.add(currentPosition);

			if (cpuTurn) {
				cpuMoves.add(currentPosition);
			} else {
				player1Moves.add(currentPosition);
			}
		}
		return checkWinner();
	}

	public int generateCpuMove() {
		Random random = new Random();
		while (true) {
			int generatedMove = random.nextInt(9) + 1;
			if (!allMoves.contains(generatedMove)) {
				return generatedMove;
			} 
		}
	}

	public int checkWinner() {

		for (int i = 0; i < winningMoves.length; i++) {
			int player1WinningMoveCount = 0;
			int cpuMatchingMoveCount = 0;

			for (int j = 0; j < winningMoves[i].length ; j++) {
				if (player1Moves.contains(winningMoves[i][j]) && player1Moves.size() >= 3) {
					player1WinningMoveCount++;

					if (player1WinningMoveCount == 3) {
						return 0;
					}
				}//player1

				if (cpuMoves.contains(winningMoves[i][j]) && cpuMoves.size() >= 3) {
					cpuMatchingMoveCount++;

					if (cpuMatchingMoveCount == 3) {
						return 0;
					}
				}//cpu
			}
		}
		//to do tie
		return 1;
	}
}