package Programmers.kakao.미로_탈출_명령어;


class Solution {

  static int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
  static char[] store = new char[]{'d', 'l', 'r', 'u'};
  static int[][] map;
  static int n, m;
  static int endX, endY;
  static boolean[][][] visited;
  static String result;
  static boolean isFlag = false;

  public String solution(int n, int m, int x, int y, int r, int c, int k) {
    map = new int[n + 1][m + 1];
    this.n = n;
    this.m = m;
    endX = r;
    endY = c;
    visited = new boolean[n + 1][m + 1][2501];

    visited[x][y][0] = true;
    dfs("", k, 0, x, y);

    if (result == null) {
      return "impossible";
    }

    return result;
  }

  public void dfs(String str, int remain, int state, int x, int y) {
    if (isFlag) {
      return;
    }

    if (remain == 0) {
      return;
    }

    for (int d = 0; d < 4; d++) {
      int nx = x + dir[d][0];
      int ny = y + dir[d][1];

      if (nx < 1 || ny < 1 || nx > n || ny > m || visited[nx][ny][state + 1]) {
        continue;
      }

      if (remain == 1 && nx == endX && ny == endY) {
        result = str + store[d];
        isFlag = true;
        return;
      }

      visited[nx][ny][state + 1] = true;
      dfs(str + store[d], remain - 1, state + 1, nx, ny);
    }
  }
}

