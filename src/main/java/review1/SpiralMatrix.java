package review1;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        List<Integer> res = new ArrayList<>();

        int curDir = 0; // 0:右, 1:下, 2:左, 3:上
        int row = 0, col = 0;

        while (res.size() < rows * cols) {
            if (visited[row][col] == 0) {
                res.add(matrix[row][col]);
                visited[row][col] = 1;
            }

            switch (curDir) {
                case 0: // 右
                    if (col + 1 < cols && visited[row][col + 1] == 0) {
                        col++;
                    } else {
                        curDir = 1; // 转向下
                    }
                    break;
                case 1: // 下
                    if (row + 1 < rows && visited[row + 1][col] == 0) {
                        row++;
                    } else {
                        curDir = 2; // 转向左
                    }
                    break;
                case 2: // 左
                    if (col - 1 >= 0 && visited[row][col - 1] == 0) {
                        col--;
                    } else {
                        curDir = 3; // 转向上
                    }
                    break;
                case 3: // 上
                    if (row - 1 >= 0 && visited[row - 1][col] == 0) {
                        row--;
                    } else {
                        curDir = 0; // 转向右
                    }
                    break;
            }
        }

        return res;
    }
}
