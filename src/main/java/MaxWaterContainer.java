/**
 * 盛最多水的容器
 */
public class MaxWaterContainer {
    // 短小的一边先往回缩
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
