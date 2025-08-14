package review1;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * // TODO:方案：二分找到 >= x 的第一个数字
 */
public class FirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        int l=search(nums,target);
        int r=search(nums,target+1);
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }
    // 找 >=target 的第一个
    public int search(int[] nums,int target){
        int l = 0, r = nums.length;
        while (l < r) {// r = mid、l = mid + 1 最后return l(还需要判断l是否越界)
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

}
