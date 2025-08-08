/**
 * 爬楼梯
 * // TODO 很好理解，因为每次只能爬 1 级或 2 级，所以 f(x) 只能从 f(x−1) 和 f(x−2) 转移过来
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
