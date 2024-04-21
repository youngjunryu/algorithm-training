package LeetCode.medium.Search_a_2D_Matrix;

class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    int left = 0;
    int right = n * m - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      int val = matrix[mid / m][mid % m];

      if (target == val) {
        return true;
      } else if (val < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }
}
