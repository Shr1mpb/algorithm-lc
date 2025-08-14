package review1;

/**
 * 跳跃游戏
 * // TODO 最远超过 说明能跳得到
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i <= max) {// 当前位置在最远位置之前 说明可以从当前位置出发
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            }else{
                break;
            }
        }
        return false;
    }
}
