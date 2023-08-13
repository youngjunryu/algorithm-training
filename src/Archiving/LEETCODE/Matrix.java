package Archiving.LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
  public int[][] updateMatrix(int[][] mat) {
    int[][] dir = {{0 , 1}, {0, -1}, {-1, 0}, {1, 0}};
    int n = mat.length;
    int m = mat[0].length;
    Queue<Node> q = new LinkedList<>();
    int[][] map = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          q.add(new Node(i, j));
        } else {
          map[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();
      for (int[] d : dir) {
        int nx = cur.x + d[0];
        int ny = cur.y + d[1];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] <= map[cur.x][cur.y] + 1) {
          continue;
        }

        map[nx][ny] = map[cur.x][cur.y] + 1;
        q.add(new Node(nx, ny));
      }
    }

    return map;
  }

  private class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
