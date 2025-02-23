import java.util.*;

class Sudoku_Solver {

	public static boolean solveSudoku(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) { // Empty cell represented by 0

					for (int num = 1; num <= 9; num++) {
						if (isValid(board, i, j, num)) {
							board[i][j] = num;

							if (solveSudoku(board))
								return true;
							else
								board[i][j] = 0; // Backtrack
						}
					}

					return false; // No valid number found, backtrack
				}
			}
		}
		return true; // Puzzle solved
	}

	public static boolean isValid(int[][] board, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == num) // Check column
				return false;

			if (board[row][i] == num) // Check row
				return false;

			// Check 3x3 subgrid
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int[][] board = {
				{ 9, 5, 7, 0, 1, 3, 0, 8, 4 },
				{ 4, 8, 3, 0, 5, 7, 1, 0, 6 },
				{ 0, 1, 2, 0, 4, 9, 5, 3, 7 },
				{ 1, 7, 0, 3, 0, 4, 9, 0, 2 },
				{ 5, 0, 4, 9, 7, 0, 3, 6, 0 },
				{ 3, 0, 9, 5, 0, 8, 7, 0, 1 },
				{ 8, 4, 5, 7, 9, 0, 6, 1, 3 },
				{ 0, 9, 1, 0, 3, 6, 0, 7, 5 },
				{ 7, 0, 6, 1, 8, 5, 4, 0, 9 }
		};

		if (solveSudoku(board)) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
		} else {
			System.out.println("No solution exists for the given Sudoku puzzle.");
		}
	}
}
