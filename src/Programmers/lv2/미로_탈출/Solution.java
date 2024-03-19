package Programmers.lv2.미로_탈출;

import java.util.*;

class Solution {
  int n, m;
  char[][] map;
  boolean[][] visited;
  int[][] result;
  int startX, startY;
  int endX, endY;
  int leverX, leverY;
  int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int solution(String[] maps) {
    n = maps.length;
    m = maps[0].length();
    map = new char[n][m];
    result = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = maps[i].charAt(j);
        if (c == 'S') {
          startX = i;
          startY = j;
        } else if (c == 'E') {
          endX = i;
          endY = j;
        } else if (c == 'L') {
          leverX = i;
          leverY = j;
        }
        map[i][j] = c;
      }
    }

    bfs(startX, startY, leverX, leverY);
    if (result[leverX][leverY] == 0)
      return -1;

    bfs(leverX, leverY, endX, endY);
    if (result[endX][endY] == 0)
      return -1;
    return result[endX][endY];
  }

  public void bfs(int x, int y, int endX, int endY) {
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{x, y});
    visited = new boolean[n][m];
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int d = 0; d < 4; d++) {
        int dx = dir[d][0] + cur[0];
        int dy = dir[d][1] + cur[1];

        if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy] || map[dx][dy] == 'X') {
          continue;
        }

        if (dx == endX && dy == endY) {
          result[dx][dy] = result[cur[0]][cur[1]] + 1;
          return;
        }

        visited[dx][dy] = true;
        result[dx][dy] = result[cur[0]][cur[1]] + 1;
        q.add(new int[]{dx, dy});
      }
    }
  }
}
