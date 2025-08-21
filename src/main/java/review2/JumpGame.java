package review2;

/**
 * 跳跃游戏
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                break;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
