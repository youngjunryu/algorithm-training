package LeetCode.medium.Surrounded_Regions;

import java.util.*;

class Solution {
  public void solve(char[][] board) {
    int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if ((i == 0 || j == 0 || i == board.length -1 || j == board[0].length - 1)
            && board[i][j] == 'O') {
          board[i][j] = 'A';
          q.add(new int[]{i, j});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int dx = cur[0] + d[i][0];
        int dy = cur[1] + d[i][1];

        if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length) {
          continue;
        }

        if (board[dx][dy] == 'X' || board[dx][dy] == 'A') {
          continue;
        }

        board[dx][dy] = 'A';
        q.add(new int[]{dx, dy});
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'A') {
          board[i][j] = 'O';
        }
      }
    }
  }
}
