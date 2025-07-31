import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class FullArray {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtracking(res, cur, nums);
        return res;
    }

    private static void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int num : nums) {
            if (cur.contains(num)) {
                continue;
            }
            cur.add(num);
            backtracking(res, cur, nums);
            cur.removeLast();
        }
    }
}
