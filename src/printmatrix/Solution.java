package printmatrix;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        int xlength = matrix.length;
        int ylength = matrix[0].length;
        int start = 0;
        for (; xlength > 0 && ylength > 0; start++, xlength = xlength - 2, ylength = ylength - 2) {
            if (ylength == 1) {
                for (int x = start, y = start; x < start + xlength; x++) {
                    result.add(matrix[x][y]);
                }
                break;
            }
            if (xlength == 1) {
                for (int x = start, y = start; y < start + ylength; y++) {
                    result.add(matrix[x][y]);
                }
                break;
            }
            for (int x = start, y = start; y < start + ylength; y++) {
                result.add(matrix[x][y]);
            }
            for (int x = start + 1, y = start + ylength - 1; x < start + xlength; x++) {
                result.add(matrix[x][y]);
            }
            for (int x = start + xlength - 1, y = start + ylength - 2; y >= start; y--) {
                result.add(matrix[x][y]);
            }
            for (int x = start + xlength - 2, y = start; x >= start + 1; x--) {
                result.add(matrix[x][y]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int[][] matrix3 = {{1}, {2}, {3}, {4}, {5}};
        int[][] matrix4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        Solution solution = new Solution();
//        System.out.println(solution.printMatrix(matrix));
//        System.out.println(solution.printMatrix(matrix1));
        System.out.println(solution.printMatrix(matrix2));
        System.out.println(solution.printMatrix(matrix3));
        System.out.println(solution.printMatrix(matrix4));


    }
}
