package review1;

/**
 * 寻找旋转排序数组中的最小值
 */
public class FindMinimumValueInRotatedSortArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        int ret = nums[0];
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            ret = Math.min(ret, nums[mid]);
            if(nums[0] <= nums[mid]) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ret;
    }
}
