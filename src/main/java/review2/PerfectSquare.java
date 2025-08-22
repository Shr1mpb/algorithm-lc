package review2;

/**
 * 完全平方数
 * // TODO2: 重温
 */
public class PerfectSquare {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // 差一步j*j到f[i]的最小步数
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }
}
