package game;

import static game.Mark.*;

public class Board {
	private final Mark board[][];
	private Mark winningMark;
	private final int BOARD_WIDTH = 3;
	private int availableMoves = BOARD_WIDTH * BOARD_WIDTH;
	private boolean crossTurn, gameOver;

	public Board() {
		board = new Mark[BOARD_WIDTH][BOARD_WIDTH];
		crossTurn = true;
		gameOver = false;
		winningMark = BLANK;
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < BOARD_WIDTH; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				board[i][j] = BLANK;
			}
		}
	}

	public boolean placeMark(int row, int colunm) {
		if (row < 0 || row >= BOARD_WIDTH || colunm < 0 || colunm >= BOARD_WIDTH || isTileMarked(row, colunm)
				|| gameOver) {
			return false;
		}
		availableMoves--;
		board[row][colunm] = crossTurn ? X : O;
		togglePlayer();
		checkWin(row, colunm);
		return true;
	}

	// Kiem tra nguoi thang

	private void checkWin(int row, int column) {
		int rowSum = 0;
		// Kiem tra hang
		for (int c = 0; c < BOARD_WIDTH; c++) {
			rowSum += getMarkAt(row, c).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		// Kiem tra cot
		rowSum = 0;
		for (int r = 0; r < BOARD_WIDTH; r++) {
			rowSum += getMarkAt(r, column).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		// Kiem tra duong cheo tu tren ben trai den duoi cung ben phai
		rowSum = 0;
		for (int i = 0; i < BOARD_WIDTH; i++) {
			rowSum += getMarkAt(i, i).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		// Kiem tra duong cheo tren ben phai sang duoi ben trai
		rowSum = 0;
		int indexMax = BOARD_WIDTH - 1;
		for (int i = 0; i <= indexMax; i++) {
			rowSum += getMarkAt(i, indexMax - i).getMark();
		}
		if (calcWinner(rowSum) != BLANK) {
			return;
		}
		if (!anyMovesAvailable()) {
			gameOver = true;
		}
	}

	// Goi nguoi thang
	private Mark calcWinner(int rowSum) {
		int xWin = X.getMark() * BOARD_WIDTH;
		int oWin = O.getMark() * BOARD_WIDTH;
		if (xWin == rowSum) {
			gameOver = true;
			winningMark = X;
			return X;
		} else if (oWin == rowSum) {
			gameOver = true;
			winningMark = O;
			return O;
		}
		return BLANK;
	}

	private void togglePlayer() {
		crossTurn = !crossTurn;
	}

	public boolean anyMovesAvailable() {
		return availableMoves > 0;
	}

	public Mark getMarkAt(int row, int column) {
		return board[row][column];
	}

	public boolean isTileMarked(int row, int column) {
		return board[row][column].isMarked();
	}

	public void setMarkAt(int row, int column, Mark newMark) {
		board[row][column] = newMark;
	}

	public boolean isCrossTurn() {
		return crossTurn;
	}

	public int getWidth() {
		return BOARD_WIDTH;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public Mark getWinningMark() {
		return winningMark;
	}

	public int getAvailableMoves() {
		return availableMoves;
	}

	public void setAvailableMoves(int availableMoves) {
		this.availableMoves = availableMoves;
	}

}
