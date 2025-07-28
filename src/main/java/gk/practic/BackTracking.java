package gk.practic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackTracking {

    public boolean nQueen(boolean[][] board, int row, int N) {
        if(row == N) {
            return true;
        }
        for (int col = 0; col < N ; col++) {
            if(isSafeToPlace(board, row, col, N)) {
                board[row][col] = true;
                if(nQueen(board, row+1, N)) {
                    return true;
                }
                board[row][col] = false; // BACKTRACKING
            }
        }
        return false;
    }

    private boolean isSafeToPlace(boolean[][] board, int row, int col, int N) {
        return !containsOtherQueenInRow(board, row, col, N) && !containsOtherQueenInCol(board, row,  col, N) &&
                !containsOtherQueenDiagonally(board, row, col, N);
    }

    private boolean containsOtherQueenDiagonally(boolean[][] board, int row, int col, int N) {
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return true;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j]) {
                return true;
            }
        }

        // Check lower-left diagonal
        for (int i = row + 1, j = col - 1; i < N && j >= 0; i++, j--) {
            if (board[i][j]) {
                return true;
            }
        }

        // Check lower-right diagonal
        for (int i = row + 1, j = col + 1; i < N && j < N; i++, j++) {
            if (board[i][j]) {
                return true;
            }
        }

        return false;
    }


    private boolean containsOtherQueenInCol(boolean[][] board, int row, int col, int N) {
        for (int i = 0; i < N; i++) {
            if(i != row) {
                if(board[i][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsOtherQueenInRow(boolean[][] board, int row, int col, int N) {
        for (int i = 0; i < N; i++) {
            if(i != col) {
                if(board[row][i]) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void testNQueen() {
        int N = 4;
        boolean[][] board = new boolean[N][N];
        assertTrue(nQueen(board, 0, N));
    }

    @Test
    public void testSafeToPlace() {
        int N = 4;
        boolean[][] board = {
                {false, false, false, false},
                {true, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };
        assertFalse(containsOtherQueenInRow(board, 3, 2, 4));
        assertTrue(containsOtherQueenInRow(board, 1, 3, 4));
        assertFalse(containsOtherQueenInCol(board, 2, 3, 4));
        assertTrue(containsOtherQueenInCol(board, 2, 0, 4));
    }
}
