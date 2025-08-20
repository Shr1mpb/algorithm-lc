package review1;

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
}
