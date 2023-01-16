package LEETCODE;

class Word_Search {
  int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  int n, m;
  boolean result;

  public boolean exist(char[][] board, String word) {
    n = board.length;
    m = board[0].length;

    boolean flag = false;
    for (int i = 0; i < n && !flag; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == word.charAt(0)) {
          boolean[][] visited = new boolean[n][m];
          visited[i][j] = true;
          if(dfs(i, j, 0, visited, word, board)) {
            flag = true;
            break;
          }
          visited[i][j] = true;
        }
      }
    }

    if (flag) {
      return true;
    }
    return false;
  }

  public boolean dfs(int x, int y, int cur, boolean[][] visited, String word, char[][] board) {
    if (cur == word.length() - 1) {
      return true;
    }

    for (int i = 0; i < 4; i++) {
      int dx = x + d[i][0];
      int dy = y + d[i][1];
      if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy]) {
        continue;
      }

      if (word.charAt(cur + 1) == board[dx][dy]) {
        visited[dx][dy] = true;
        if (dfs(dx, dy, cur + 1, visited, word, board)) {
          return true;
        }
        visited[dx][dy] = false;
      }
    }

    return false;
  }
}
