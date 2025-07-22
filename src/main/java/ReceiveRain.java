import java.util.ArrayList;
import java.util.List;

/**
 * 接雨水
 */
public class ReceiveRain {
    // 按行接 时间超限
    public int trap0(int[] height) {
        // 按行接雨水
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }
        // 对高度循环 记录每层雨水
        int sum = 0;
        for (int i = 1 ; i <= maxHeight; i++) {
            // 记录本层所有高度>=i的柱子
            List<Integer> indexes = new ArrayList<Integer>();
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i){
                    indexes.add(j);
                }
            }
            if (indexes.size() < 2) {
                return sum;
            }
            sum += indexes.getLast() - indexes.getFirst() - 1 - (indexes.size() - 2);
        }
        return sum;
    }


    // 按列搜索 两边同时向内 计算边
    // TODO
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

}
