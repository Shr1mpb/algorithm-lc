package review1;

/**
 * 寻找重复数
 */
public class FindRepeatNumber {
    public int findDuplicate(int[] nums) {
        // 一定有环
        // 让index为节点 value为指针 则两个相同值会指向同一个节点 也就是成环
        int slow = 0;// =head
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 快慢相遇的时候，即到了环中
        // 到环中后，让一个指针=0 同时走一步 相等的时候即遇见的时候
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
