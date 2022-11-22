package ai;

import static game.Mark.O;
import static game.Mark.X;
import static game.Mark.BLANK;
import game.Board;
public class Minimax {
	private static final int MAX_DEPTH = 6;

	public static int Minimax(Board board, int depth, boolean isMax) {
		int boardVal = evaluateBoard(board);
		
		if (Math.abs(boardVal) == 10 || depth == 0 || !board.anyMovesAvailable()) {
			return boardVal;
		}
		
		if (isMax) {
			int highestVal = Integer.MIN_VALUE;
			for (int row = 0; row< board.getWidth(); row ++) {
				for (int col = 0; col < board.getWidth(); col++) {
					if (!board.isTileMarked(row, col)) {
						board.setMarkAt(row, col, X);
						highestVal = Math.max(highestVal, Minimax(board, depth - 1, false));
						board.setMarkAt(row, col, BLANK);
					}
						
				}
			}
			return highestVal;
		}
		else {
			int lowestVal = Integer.MAX_VALUE;
			for (int row = 0; row< board.getWidth(); row ++) {
				for (int col = 0; col < board.getWidth(); col++) {
					if (!board.isTileMarked(row, col)) {
						board.setMarkAt(row, col, O);
						lowestVal = Math.min(lowestVal, Minimax(board, depth - 1, true));
						board.setMarkAt(row, col, BLANK);
					}
						
				}
			}
			return lowestVal;
		}
	}
	
	public static int[] getBestMove (Board board) {
		int bestMove[] = new int[] {-1, -1};
		int bestValue = Integer.MIN_VALUE;
		
		for (int row = 0; row < board.getWidth(); row ++) {
			for (int col = 0; col < board.getWidth(); col ++) {
				if (!board.isTileMarked(row, col)) {
					board.setMarkAt(row, col, X);
					int moveValue = Minimax(board, MAX_DEPTH, false);
					board.setMarkAt(row, col, BLANK);
					if (moveValue > bestValue) {
						bestMove[0] = row;
						bestMove[1] = col;
						bestValue =moveValue;
					}
				}
			}
		}
		return bestMove;
	}
	
	public static int evaluateBoard(Board board) {
		int rowSum = 0;
		int bWidth = board.getWidth();
		int xWin = X.getMark() * bWidth;
		int oWin = O.getMark() * bWidth;
		// Kiem tra hang
		for (int row = 0; row < bWidth; row ++) {
			for (int col = 0; col < bWidth; col++) {
				rowSum += board.getMarkAt(row, col).getMark();
			}
			if (rowSum == xWin)
				return 10;
			else if (rowSum == oWin) {
				return -10;
			}
			rowSum = 0;
		}
		// Kiem tra cot
		rowSum = 0;
        for (int col = 0; col < bWidth; col++) {
            for (int row = 0; row < bWidth; row++) {
                rowSum += board.getMarkAt(row, col).getMark();
            }
            if (rowSum == xWin) {
                return 10;
            } else if (rowSum == oWin) {
                return -10;
            }
            rowSum = 0;
        }
		// Kiem tra duong cheo tu tren ben trai den duoi cung ben phai
        rowSum = 0;
        for (int i = 0; i < bWidth; i++) {
            rowSum += board.getMarkAt(i, i).getMark();
        }
        if (rowSum == xWin) {
            return 10;
        } else if (rowSum == oWin) {
            return -10;
        }
		// Kiem tra duong cheo tren ben phai sang duoi ben trai
        rowSum = 0;
        int indexMax = bWidth - 1;
        for (int i = 0; i <= indexMax; i++) {
            rowSum += board.getMarkAt(i, indexMax - i).getMark();
        }
        if (rowSum == xWin) {
            return 10;
        } else if (rowSum == oWin) {
            return -10;
        }

        return 0;
	}
}
