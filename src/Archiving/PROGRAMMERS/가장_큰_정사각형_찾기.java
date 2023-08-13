package Archiving.PROGRAMMERS;

public class 가장_큰_정사각형_찾기 {
  public int solution(int[][] board) {
    int n = board.length;
    int m = board[0].length;
    int maxLen = 0;

    int[][] map = new int[n+1][m+1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (board[i-1][j-1] == 1) {
          int min = Math.min(map[i-1][j], Math.min(map[i][j-1], map[i-1][j-1]));
          map[i][j] = min + 1;

          maxLen = Math.max(maxLen, min + 1);
        }
      }
    }

    return maxLen * maxLen;
  }
}
