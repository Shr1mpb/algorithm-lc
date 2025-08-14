package review1;

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
    // leetcode 官解 没有讲解 屎
    public int trap1(int[] height) {
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

    // 本质上 双指针是前缀最大值和后缀最大值方法 优化空间复杂度得来
    // 左右维护最大值 如果左最大值比右小 则当前位置接水由左最大值确定
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
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
