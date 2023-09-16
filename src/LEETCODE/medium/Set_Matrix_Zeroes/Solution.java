package LeetCode.medium.Set_Matrix_Zeroes;

import java.util.*;

class Solution {
  public void setZeroes(int[][] matrix) {
    HashSet<Integer> colSet = new HashSet<>();
    HashSet<Integer> rowSet = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rowSet.add(i);
          colSet.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (rowSet.contains(i)) {
          matrix[i][j] = 0;
        }

        if (colSet.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
