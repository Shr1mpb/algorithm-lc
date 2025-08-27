package review2;

/**
 * 跳跃游戏 II
 * // TODO2: 重温 到上一条边界进行跳跃
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int preEnd = 0;
        int farthest = 0;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == preEnd) {
                preEnd = farthest;
                count++;
            }
            if (preEnd >= length - 1) {
                return count;
            }
        }
        return count;
    }
}
