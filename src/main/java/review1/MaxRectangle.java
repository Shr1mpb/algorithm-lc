package review1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 * // TODO 每日温度进阶版
 */
public class MaxRectangle {
    // 固定高，然后向两边扩散，获得最大值
    // left、right存放 该索引下左/右边第一个比它高度小的位置，即扩散到的位置的边缘 -1代表到左边尽头
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        // 左每日温度 从右边开始放置
        Arrays.fill(left, -1);
        Arrays.fill(right, n);// 默认都到最后
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        // 右每日温度
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        // 计算每个地方的最大矩形 然后更新最大值
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
