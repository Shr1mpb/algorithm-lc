package review1;

/**
 * 单词搜索
 */
public class WordSearch {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        char[] cWord = word.toCharArray();
        // 统计board和word的字符频率
        int[] dict = new int[128];  // 存储board中每个字符的出现次数
        int[] cDict = new int[128]; // 存储word中每个字符的出现次数
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dict[board[i][j]]++;
            }
        }
        for(int i = 0; i < cWord.length; i++) {
            if(++cDict[cWord[i]] > dict[cWord[i]]) return false; // word的字符在board中不足
        }
        // 优化：如果word的首字符比尾字符更稀有，反转word以减少搜索量
        if(cDict[cWord[0]] > cDict[cWord[cWord.length - 1]]) {
            cWord = new StringBuilder(word).reverse().toString().toCharArray();
        }
        // 遍历board的每个起点，尝试DFS
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, cWord, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if(board[i][j] != word[index]) return false; // 非当前查找字符
        if(index == word.length - 1) return true; // 找到了
        // 以上是递归出口
        // 递归逻辑：
        board[i][j] = 0;// 这里置为已访问
        for(int[] dir : DIRS) {// 四个方向都走一次
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && dfs(board, word, x, y, index + 1)) return true;
        }
        board[i][j] = word[index];// 置回原本的样子
        return false;
    }
}
