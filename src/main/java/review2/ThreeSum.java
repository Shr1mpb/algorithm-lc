package review2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        // 循环，确定一个数，找剩下两个数
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            if (cur > 0) {
                break;
            }else if (2 * max + cur < 0) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = -cur;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 跳过重复元素 没必要计算
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else if(sum > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }
}
