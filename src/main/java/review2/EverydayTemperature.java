package review2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 每日温度
 */
public class EverydayTemperature {
    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> q = new ArrayDeque<>(temperatures.length);
        int[] res = new int[temperatures.length];
        q.push(0);
        for (int i = 0; i < temperatures.length; i++) {
            while (!q.isEmpty() && temperatures[q.peek()] < temperatures[i]) {
                Integer pop = q.pop();
                res[pop] = i - pop;
            }
            q.push(i);
        }
        return res;
    }
}
