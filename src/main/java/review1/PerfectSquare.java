package review1;

/**
 * 完全平方数
 * // TODO
 * f[i] 表示最少需要多少个数的平方来表示整数 i 这些数必然落在区间 [1,根i]
 * f[i] = 1 + min(j 1 ~ 根i f[i-j^2])
 */
public class PerfectSquare {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;// 在f[i-j*j]的基础上再额外加一个j^2
        }
        return f[n];
    }
}
