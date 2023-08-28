package LeetCode.medium.Valid_Sudoku;

import java.util.*;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];

        if (c == '.') {
          continue;
        }

        if (!set.add(i + "row" + c) || !set.add(j + "col" + c) || !set.add(i/3 + " " + j/3 + " " + c)) {
          return false;
        }
      }
    }

    return true;
  }
}
