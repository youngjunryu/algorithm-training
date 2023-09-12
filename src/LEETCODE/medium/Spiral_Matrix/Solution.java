package LeetCode.medium.Spiral_Matrix;

import java.util.*;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<>();

    int aS = 0;
    int aE = matrix.length - 1;
    int bS = 0;
    int bE = matrix[0].length - 1;

    while (aS <= aE && bS <= bE) {
      for (int i = bS; i <= bE; i++) {
        result.add(matrix[aS][i]);
      }
      aS++;

      for (int i = aS; i <= aE; i++) {
        result.add(matrix[i][bE]);
      }
      bE--;

      if (aS <= aE) {
        for (int i = bE; i >= bS; i--) {
          result.add(matrix[aE][i]);
        }
      }
      aE--;

      if (bS <= bE) {
        for (int i = aE; i >= aS; i--) {
          result.add(matrix[i][bS]);
        }
      }
      bS++;
    }

    return result;
  }
}
