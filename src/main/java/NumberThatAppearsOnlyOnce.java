/**
 * 只出现一次的数字
 * // TODO: 技巧 ^
 */
public class NumberThatAppearsOnlyOnce {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = 0;
        for (int num : nums) {
            res ^= num;// 按位异或后 出现两次的数字将会变成0
        }
        return res;
    }
}
