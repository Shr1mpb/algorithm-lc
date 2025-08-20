package review2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 * // TODO2: 重温
 */
public class MaxRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}
