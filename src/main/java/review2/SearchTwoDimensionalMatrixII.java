package review2;

/**
 * 搜索二维矩阵 II
 */
public class SearchTwoDimensionalMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[m - 1][n - 1] < target) {
            return false;
        }
        int curM = 0;
        int curN = n - 1;
        while (curM < m && curN >= 0) {
            if (matrix[curM][curN] == target) {
                return true;
            }else if (matrix[curM][curN] > target) {
                curN--;
            }
            else {
                curM++;
            }
        }
        return false;
    }
}
