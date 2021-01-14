package org.eldi.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameUtil {
	public final static int PLAYER_WINS = 1;
	public final static int INVALID_MOVE = -1;
	public final static int NOBODY_WINS = 0;
	public final static int CONTINUE = 2;
	
	private final int[][] winningMoves = { {1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, 
			{3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9} };

	private List<Integer> allMoves;

	private PlayerType player1;
	private PlayerType cpu;
	
	private Scanner scanner;

	public GameUtil(Scanner scanner) {
		this.scanner = scanner;
		this.allMoves = new ArrayList<>();
	}
	
	public PlayerType getPlayer1() {
		return player1;
	}
	
	public PlayerType getCpu() {
		return cpu;
	}

	public void setPlayerType() {
		while (true) {
			System.out.println("Type x or o");
			char playerChar = scanner.nextLine().toLowerCase().trim().charAt(0);

			if (playerChar == 'x') {
				this.player1 = PlayerType.X;
				return;
			}
			
			if (playerChar == 'o') {
				this.player1 = PlayerType.O;
				return;
			}
		}
	}
	
	public void setCpuChar() {
		this.cpu = this.player1 == PlayerType.X ? PlayerType.O : PlayerType.X;
	}

	// TODO implement undo
	public int makeMove(Integer currentMove, PlayerType currentPlayer) {
		String inputValidationRegex = "[1-9]{1}";
		
		if (allMoves.contains(currentMove) 
				|| !currentMove.toString().matches(inputValidationRegex)) {
			return INVALID_MOVE;
		}

		allMoves.add(currentMove);
		currentPlayer.addMove(currentMove);

		return checkWinner(currentPlayer);
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

	public int checkWinner(PlayerType currentPlayer) {
		
		List<Integer> currentPlayerMoves = currentPlayer.getMoves();

		for (int i = 0; i < winningMoves.length; i++) {

			if (currentPlayerMoves.size() > 2
					&& currentPlayerMoves.contains(winningMoves[i][0]) 
					&& currentPlayerMoves.contains(winningMoves[i][1])
					&& currentPlayerMoves.contains(winningMoves[i][2])) {
				return PLAYER_WINS;
			}
		}

		if (this.allMoves.size() == 9) {
			return NOBODY_WINS;
		}
		
		return CONTINUE;
		
	}
}
