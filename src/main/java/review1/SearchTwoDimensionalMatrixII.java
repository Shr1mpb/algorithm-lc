package review1;

/**
 * 搜索二维矩阵 II
 */
public class SearchTwoDimensionalMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row <= rows - 1 && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
               row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}
