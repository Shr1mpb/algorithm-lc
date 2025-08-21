package review2;

import java.util.Stack;
/**
 * 最小栈
 * 存储差值 负数更新min
 */
public class MinStack {
    Integer min = null;
    Stack<Long> data = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {
        if (data.isEmpty()) {
            data.push(0L);
            min = x;
        } else {
            // 如果新数比旧数小 diff是负数 且min会更新为新数
            data.push(Long.valueOf(x) - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        Long diff = data.pop();
        if (diff < 0) {// 如果弹出的是负数 还原出之前的最小值
            min = (int) (min - diff);
        }
    }

    public int top() {
        Long diff = data.peek();
        if (diff >= 0) {
            return (int) (min + diff);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}
