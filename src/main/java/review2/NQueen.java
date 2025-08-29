package review2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 */
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtracking(0, board, result, n);
        return result;
    }

    private void backtracking(int row, char[][] board, List<List<String>> result, int n) {
        // 第 n-1 标号的行放完后 进入这个判断 记录答案并返回
        if (row == n) {
            List<String> ans = new ArrayList<>(n);
            StringBuilder sb = new StringBuilder();
            for (char[] r : board) {
                for (char c : r) {
                    sb.append(c);
                }
                ans.add(sb.toString());
                sb.setLength(0);
            }
            result.add(ans);
            return;
        }
        // 对列进行循环 看能不能放
        for (int i = 0; i < n; i++) {
            // 可以放 递归+回溯
            if (isValid(row, i, board)) {
                board[row][i] = 'Q';
                backtracking(row + 1, board, result, n);
                // 回溯
                board[row][i] = '.';
            }
            // 不能放 继续下一列的循环 直到能放
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        // 检查正上方有无皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上方有无皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上方有无皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
