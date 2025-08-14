package review1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int rotten = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    rotten++;
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        if (rotten == 0) return -1;
        // 腐烂过程
        int res = 0;
        int expectedRottenCount = q.size();// 这一轮要发生腐烂的个数
        boolean rot = false; // 这轮是否发送腐烂 如果没有 那res不能增加
        while (!q.isEmpty() && expectedRottenCount-- > 0) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            // 腐烂四周的橘子
            int temp0 = Math.min(x + 1, m-1);
            if (grid[temp0][y] == 1) {
                grid[temp0][y] = 2;
                q.add(new int[]{temp0, y});
                fresh--;
                rot = true;
            }
            int temp1 = Math.min(y + 1, n-1);
            if (grid[x][temp1] == 1) {
                grid[x][temp1] = 2;
                q.add(new int[]{x, temp1});
                fresh--;
                rot = true;
            }
            int temp2 = Math.max(x - 1, 0);
            if (grid[temp2][y] == 1) {
                grid[temp2][y] = 2;
                q.add(new int[]{temp2, y});
                fresh--;
                rot = true;
            }
            int temp3 = Math.max(y - 1, 0);
            if (grid[x][temp3] == 1) {
                grid[x][temp3] = 2;
                q.add(new int[]{x, temp3});
                fresh--;
                rot = true;
            }
            // 如果达到此轮的腐烂次数 并且有橘子腐烂 重置参数
            if (expectedRottenCount == 0 && rot) {
                rot = false;
                expectedRottenCount = q.size();
                res++;
            }
        }
        if (fresh == 0) return res;
        return -1;

    }
}
