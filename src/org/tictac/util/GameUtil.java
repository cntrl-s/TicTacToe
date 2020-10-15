package org.tictac.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameUtil {
	private final int PLAYER_WINS = 0;

	private final int[][] winningMoves = { {1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, 
			{3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9} };

	private List<Integer> player1Moves = new ArrayList<>();
	private List<Integer> cpuMoves = new ArrayList<>();
	private List<Integer> allMoves = new ArrayList<>();

	// to do -> undo
	// return val 0 : win , -1 : error, 1 : tie
	public int makeMove(Integer currentMove, boolean cpuTurn) {
		String inputValidationRegex = "[1-9]{1}";
		
		if (allMoves.contains(currentMove) 
				|| !currentMove.toString().matches(inputValidationRegex)) {
			return -1;
		}

		allMoves.add(currentMove);

		if (cpuTurn) {
			cpuMoves.add(currentMove);
		} else {
			player1Moves.add(currentMove);
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

			if (player1Moves.size() > 2
					&& player1Moves.contains(winningMoves[i][0]) 
					&& player1Moves.contains(winningMoves[i][1])
					&& player1Moves.contains(winningMoves[i][2])) {
				return PLAYER_WINS;
			}

			if (cpuMoves.size() > 2 
					&& cpuMoves.contains(winningMoves[i][0])
					&& cpuMoves.contains(winningMoves[i][1])
					&& cpuMoves.contains(winningMoves[i][2])) {
				return PLAYER_WINS;
			}
		}
		//to do tie -> moves size == 9
		return 1;
	}
}