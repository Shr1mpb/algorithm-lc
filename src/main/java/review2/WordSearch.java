package review2;

/**
 * 单词搜索
 */
public class WordSearch {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        // 对每个位置DFS 看看有没有word
        char[] charArray = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, visited, charArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, boolean[][] visited, char[] word, int index) {
        if (index >= word.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (word[index] != board[row][col] || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (dfs(board, newRow, newCol, visited, word, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(new char[][]{{'a'}}, "a");
    }

}
