package review2;

/**
 * 缺失的第一个正数
 */
public class MissingFirstPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        // 未出现的正整数在1~N出现 因此只要将nums的前N个位置作为标记位 之后遍历就能找到没出现的数字
        int n = nums.length;
        // 对于所有非正数 将其记录为N+1 让它不影响标记
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 将1~N出现过的数字 对应到 0~N-1 索引位置，记录为负数，作为标记
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            // 说明之前是正整数且会影响标记 (绝对值在1~n之间)
            if (abs >= 1 && abs <= n) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }
        // 遍历数组 看看是否全是负数 如果是 返回n+1 如果不是 返回i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}