package LeetCode.medium.Rotate_Image;

class Solution {
  public void rotate(int[][] matrix) {
    int length = matrix.length;
    int[][] result = new int[length][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        result[j][length - i - 1] = matrix[i][j];
      }
    }

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        matrix[i][j] = result[i][j];
      }
    }
  }
}
