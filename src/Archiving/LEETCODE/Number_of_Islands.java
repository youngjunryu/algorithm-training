package Archiving.LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {
  static int[] dx = new int[]{0, 0, -1, 1};
  static int[] dy = new int[]{1, -1, 0, 0};
  static int n;
  static int m;
  static boolean[][] visited;

  public static int numIslands(char[][] grid) {
    int cnt = 0;
    n = grid.length;
    m = grid[0].length;
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          bfs(grid, i, j);
          cnt++;
        }
      }
    }

    return cnt;
  }

  private static void bfs(char[][] grid, int i, int j) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(i, j));
    visited[i][j] = true;

    while (!q.isEmpty()) {
      Node now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now.x + dx[d];
        int ny = now.y + dy[d];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == '1') {
          visited[nx][ny] = true;
          q.add(new Node(nx, ny));
        }
      }
    }
  }

  private static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
  }
}
