package review2;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * // TODO2: 重温
 */
public class FirstAndLastIndex {
    // 二分查找后向左向右扩散
    public int[] searchRange(int[] nums, int target) {
        int l=search(nums,target);
        int r=search(nums,target+1);
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    /**
     * 找 >=target 的第一个位置
     */
    public int search(int[] nums,int target){
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 2);
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
