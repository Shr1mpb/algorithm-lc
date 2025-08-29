package review2;

/**
 * 寻找重复数
 */
public class FindRepeatNumber {
    public int findDuplicate(int[] nums) {
        // 索引范围： 0~n 数字 1~n
        // 索引：指针 数字：链表指针
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int s = 0;
        while (s != slow) {
            s = nums[s];
            slow = nums[slow];
        }
        return s;
    }
}
