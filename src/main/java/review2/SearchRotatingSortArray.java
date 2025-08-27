package review2;

/**
 * 搜索旋转排序数组
 */
public class SearchRotatingSortArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return -1;
        }
        if(n==1){
            return nums[0]==target?0:-1;
        };
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[mid] < target) {
                    start = mid + 1;
                }else{
                    if (nums[0] <= target) {
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }else{
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    if (nums[0] > target) {
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
