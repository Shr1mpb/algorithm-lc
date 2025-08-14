package review2;

/**
 * 接雨水
 */
public class ReceiveRain {
    public int trap(int[] height) {
        // 本质：左右前缀最大值
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left <= right) {// 这里逻辑分析：不需要= 因为=时一定接不了水，加上也没错，因为肯定是+0
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
