package org.tictac.view;

import java.util.ArrayList;
import java.util.List;

public enum PlayerType {
	X, O;
	
	private List<Integer> moves;
	
	private PlayerType() {
		this.moves = new ArrayList<>();
	}
	
	public List<Integer> getMoves() {
		return moves;
	}

	public void add(int move) {
		this.moves.add(move);
	}

}
