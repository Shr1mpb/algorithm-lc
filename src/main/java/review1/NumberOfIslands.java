package review1;

/**
 * 岛屿数量
 */
public class NumberOfIslands {
    private static final int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(int i, int j, char[][] grid){
        grid[i][j] = '2';// 搜索到的点置为2

        for (int di = 0; di <= 3; di++) {// 向四面继续深度优先搜索
            int x = i + DIR[di][0];
            int y = j + DIR[di][1];

            if(x >= 0 && x < m && y >= 0 && y <n && grid[x][y] != '2'  && grid[x][y] != '0'){
                dfs(x, y, grid);
            }
        }

    }
}
