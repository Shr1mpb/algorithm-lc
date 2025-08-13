/**
 * 多数元素
 * // TODO: Boyer-Moore 投票算法 摩尔投票
 */
public class MostElements {
    public int majorityElement(int[] nums) {
        int count = 0;// 票数
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {// 为0 淘汰 换下一个
                candidate = num;
            }
            // 不为0 记票
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
