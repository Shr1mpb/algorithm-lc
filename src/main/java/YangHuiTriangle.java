import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * // TODO
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 1) {
            res.add(List.of(1));
            return res;
        }
        if (numRows == 2) {
            res.add(List.of(1));
            res.add(Arrays.asList(1, 1));
            return res;
        }
        res.add(Arrays.asList(1));
        res.add(Arrays.asList(1, 1));
        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                    continue;
                }
                list.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
            }
            res.add(list);
        }
        return res;
    }
}
