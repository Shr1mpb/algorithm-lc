package review1;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinedSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        insertionSort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtracking(candidates, target, cur, 0, result, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, List<Integer> cur, int sum, List<List<Integer>> result,int index) {
        if (sum > target) {// 超过 不继续
            return;
        }
        if (sum == target){// 等于 添加进入
            result.add(new ArrayList<>(cur));
            return;
        }
        // 小于 继续加数
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {
                cur.add(candidates[i]);
                sum += candidates[i];
                backtracking(candidates, target, cur, sum, result, i);
                cur.remove(cur.size() - 1);
                sum -= candidates[i];
            } else{
                break;
            }
        }
    }

    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }
}
