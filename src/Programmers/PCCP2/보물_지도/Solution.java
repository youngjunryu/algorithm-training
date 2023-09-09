package Programmers.PCCP2.보물_지도;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] map;
  boolean[][][] visited;

  public int solution(int n, int m, int[][] hole) {
    map = new int[n + 1][m + 1];
    visited = new boolean[n + 1][m + 1][2];

    for (int[] h : hole) {
      map[h[0]][h[1]] = -1;
    }

    return bfs(m, n);
  }

  private int bfs(int m, int n) {
    int result = 0;
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1, 1, false));
    visited[1][1][0] = true;

    while (!q.isEmpty()) {
      int size = q.size();
      for (int k = 0; k < size; k++) {
        Node cur = q.poll();

        for (int i = 0; i < dir.length; i++) {
          int nx = cur.x + dir[i][0];
          int ny = cur.y + dir[i][1];

          if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && map[nx][ny] == 0 && !visited[nx][ny][cur.isJump ? 1  : 0]) {
            if (nx == n && ny == m) {
              return result + 1;
            }
            visited[nx][ny][cur.isJump ? 1 : 0] = true;
            q.add(new Node(nx, ny, cur.isJump));
          }

          if (!cur.isJump) {
            nx += dir[i][0];
            ny += dir[i][1];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && map[nx][ny] == 0 && !visited[nx][ny][1]) {
              if (nx == n && ny == m) {
                return result + 1;
              }
              visited[nx][ny][1] = true;
              q.add(new Node(nx, ny, true));
            }
          }
        }
      }

      result++;
    }

    return -1;
  }

  class Node {
    int x;
    int y;
    boolean isJump;

    public Node(int x, int y, boolean isJump) {
      this.x = x;
      this.y = y;
      this.isJump = isJump;
    }
  }
}
