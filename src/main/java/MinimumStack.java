import java.util.Stack;

/**
 * 最小栈
 * // TODO: 不用额外空间 存储 和加入时的最小值的差
 */
public class MinimumStack {
    Integer min = null;
    Stack<Long> data = new Stack<>();

    public void push(int x) {
        if (data.isEmpty()) {
            data.push(0L);
            min = x;
        } else {
            // 如果x是最小的数，这里可能越界，所以用Long来保存
            data.push(Long.valueOf(x) - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        Long diff = data.pop();
        if (diff < 0) {// 还原出之前的最小值
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
