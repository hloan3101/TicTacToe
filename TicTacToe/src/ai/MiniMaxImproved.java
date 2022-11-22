package ai;

import static game.Mark.BLANK;
import static game.Mark.O;

import game.Board;
import game.Mark;

public class MiniMaxImproved {
	private static final int MAX_DEPTH = 6;
	
	 public static int miniMax(Board board, int depth, boolean isMax) {
		 int boardVal = evaluateBoard(board, depth);
		 
		 if (Math.abs(boardVal) > 0 || depth == 0 || !board.anyMovesAvailable()) {
			 return boardVal;
		 }
		 
		 if (isMax) {
			 int highestVal = Integer.MIN_VALUE;
			 for (int row = 0; row < board.getWidth(); row ++) {
				 for (int column = 0; column < board.getWidth(); column ++) {
					 if (!board.isTileMarked(row, column)) {
						 board.setMarkAt(row, column, Mark.X);
						 highestVal = Math.max(highestVal, miniMax(board, depth -1, false));
						 board.setMarkAt(row, column, Mark.BLANK);
					 }
				 }
			 }
			 return highestVal;
		 }
		 else {
			 int lowestVal = Integer.MAX_VALUE;
	            for (int row = 0; row < board.getWidth(); row++) {
	                for (int column = 0; column < board.getWidth(); column ++) {
	                    if (!board.isTileMarked(row, column)) {
	                        board.setMarkAt(row, column, O);
	                        lowestVal = Math.min(lowestVal, miniMax(board,depth - 1, true));
	                        board.setMarkAt(row, column, BLANK);
	                    }
	                }
	            }
	            return lowestVal;
		 }
	 }
	
	 public static int[] getBestMove(Board board) {
		 int bestMove[] = new int[] {-1, -1};
		 int bestValue = Integer.MIN_VALUE;
		 
		 for (int row = 0; row < board.getWidth(); row++) {
			 for (int column = 0; column < board.getWidth(); column ++) {
				 if (!board.isTileMarked(row, column)) {
					 board.setMarkAt(row, column, Mark.X);
					 int moveValue = miniMax(board, MAX_DEPTH, false);
					 board.setMarkAt(row, column, Mark.BLANK);
					 if (moveValue > bestValue) {
						 bestMove[0] = row;
						 bestMove[1] = column;
						 bestValue = moveValue;
					 }
				 }
			 }
		 }
		 return bestMove;
	 }
	 
	private static int evaluateBoard(Board board, int depth) {
		int rowSum = 0;
		int width = board.getWidth();
		int xWin = Mark.X.getMark() * width;
		int oWin = Mark.O.getMark()*width;
		// Kiem tra hang
		for (int row = 0; row < width; row ++) {
			for (int column = 0; column < width; column ++) {
				rowSum += board.getMarkAt(row, column).getMark();
			}
			if (rowSum == xWin ) {
				return 10 + depth;
			}
			else if (rowSum == oWin) {
				return -10 - depth;
			}
			rowSum = 0;
		}
		//Kiem tra cot
		rowSum =0;
		for (int column = 0; column < width; column ++) {
			for (int row = 0; row < width; row ++) {
				rowSum += board.getMarkAt(row, column).getMark();
			}
			if (rowSum == xWin ) {
				return 10 + depth;
			}
			else if (rowSum == oWin) {
				return -10 - depth;
			}
			rowSum = 0;
		}
		// Kiem tra tren trai xuong duoi phai
		rowSum = 0;
		for (int i = 0; i< width; i ++) {
			rowSum += board.getMarkAt(i, i).getMark();
		}
		if (rowSum == xWin ) {
			return 10 + depth;
		}
		else if (rowSum == oWin) {
			return -10 - depth;
		}
		//Kiem tra tren phai xuong duoi trai
		rowSum = 0;
		int index = width - 1;
		for (int i = 0; i<= index; i++) {
			rowSum += board.getMarkAt(i, index-i).getMark();
		}
		if (rowSum == xWin ) {
			return 10 + depth;
		}
		else if (rowSum == oWin) {
			return -10 - depth;
		}
		return 0;
		
	}
}
