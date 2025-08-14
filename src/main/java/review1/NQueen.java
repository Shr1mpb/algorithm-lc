package review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * // TODO 棋盘摆放时的方法和回溯方法
 */
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0, board, res);
        return res;
    }

    private void dfs(int row, char[][] board, List<List<String>> res) {
        int n = board.length;
        if (row == n) {
            ArrayList<String> list = new ArrayList<>(n);
            for (char[] chars : board) {
                StringBuilder sb = new StringBuilder();
                for (char c : chars) {
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(row + 1, board, res); // 递归
                board[row][i] = '.';// 回溯
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col) {
        // 上方
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen solver = new NQueen();
        System.out.println(solver.solveNQueens(4));
    }
}
