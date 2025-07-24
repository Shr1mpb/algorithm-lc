import java.util.Arrays;

/**
 * 矩阵置零
 */
public class MatrixZeroing {
    public void setZeroes(int[][] matrix) {
        // O(m+n)空间 记录行列
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // 行置零
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                Arrays.fill(matrix[i], 0);
            }
        }
        // 列置零
        for (int i = 0; i < col.length; i++) {
            if (col[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
    // TODO
    // 优化：我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
}
