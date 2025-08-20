package review2;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * // TODO2 重温
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if (numRows >= 2) {
            ArrayList<Integer> secondRow = new ArrayList<>();
            secondRow.add(1);
            secondRow.add(1);
            result.add(secondRow);
        }
        // 从第三行开始循环构建
        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                    continue;
                }
                row.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            result.add(row);
        }
        return result;
    }
}
