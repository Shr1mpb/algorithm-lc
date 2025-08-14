package review1;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtracking(res, nums, 0, cur);
        return res;
    }

    // 加上i = index,index = i+1 天然去重
    private void backtracking(List<List<Integer>> res, int[] nums, int index, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        // 开始回溯
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtracking(res, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.subsets(new int[]{1, 2, 3}));
    }


}
