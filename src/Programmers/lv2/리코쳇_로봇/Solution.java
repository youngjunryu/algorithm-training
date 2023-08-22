package Programmers.lv2.리코쳇_로봇;

import java.util.*;

class Solution {
  int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  int r, c;
  int gX, gY;
  char[][] map;
  int answer = -1;

  public int solution(String[] board) {
    r = board.length;
    c = board[0].length();
    map = new char[r][c];
    int startX = -1, startY = -1;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        char c = board[i].charAt(j);
        if (c == 'R') {
          startX = i;
          startY = j;
        } else if (c == 'G') {
          gX = i;
          gY = j;
        }

        map[i][j] = c;
      }
    }

    bfs(startX, startY, 0);

    return answer;
  }

  private void bfs(int startX, int startY, int cnt) {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[r][c];
    q.add(new int[]{startX, startY, cnt});
    visited[startX][startY] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];
      int ccnt = cur[2];

      if (x == gX && y == gY) {
        answer = ccnt;
        return;
      }

      for (int d = 0; d < 4; d++) {
        int[] nextCur = goStraight(x, y, dir[d]);
        System.out.println(nextCur[0] + " " + nextCur[1]);
        if (visited[nextCur[0]][nextCur[1]]) {
          continue;
        }

        visited[nextCur[0]][nextCur[1]] = true;
        q.add(new int[]{nextCur[0], nextCur[1], ccnt + 1});
      }
    }
  }

  private int[] goStraight(int curX, int curY, int[] d) {
    while (true) {
      int nextX = curX + d[0];
      int nextY = curY + d[1];

      if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c ||
          map[nextX][nextY] == 'D') {
        return new int[]{curX, curY};
      }

      curX = nextX;
      curY = nextY;
    }
  }
}
