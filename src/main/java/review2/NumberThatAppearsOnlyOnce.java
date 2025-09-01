package review2;

/**
 * 只出现一次的数字
 */
public class NumberThatAppearsOnlyOnce {
    public int singleNumber(int[] nums) {
        // 出现两次的数字 抑或后会变成0
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
