class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length - 1;
        while (col < matrix[0].length && row >= 0) {
           if (matrix[row][col] == target) {
            return true;
           } else if (matrix[row][col] > target) {
            row--;
           } else {
            col++;
           }
        }
        return false;
    }
}
