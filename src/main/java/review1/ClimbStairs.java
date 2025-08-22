package review1;

/**
 * 爬楼梯
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // f(x)=f(x−1)+f(x−2)1
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
