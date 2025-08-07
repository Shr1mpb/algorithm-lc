/**
 * 跳跃游戏 II
 * // TODO 每次更新最远 到达跳跃边界更新跳跃次数 仍然是“可达”分析 不需要具体路线
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int ans = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);// 这一跳范围内能跳到的最远距离更新
            if (i == currentEnd) { // 到达上一跳的边界 相当于必须要向前跳一步
                currentEnd = farthest;// 更新下一次向前跳的边界
                ans++;
                if (currentEnd >= nums.length - 1) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
