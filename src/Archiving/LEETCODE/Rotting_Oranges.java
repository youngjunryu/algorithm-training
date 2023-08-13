package Archiving.LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
  static int[] dx = new int[]{0, 0, -1, 1};
  static int[] dy = new int[]{1, -1, 0, 0};
  static int n;
  static int m;
  static Queue<Node> q;
  static boolean[][] visited;
  static int cnt;
  static int answer;

  public static int orangesRotting(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    q = new LinkedList<>();
    visited = new boolean[n][m];
    cnt = 0;
    answer = -1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          visited[i][j] = true;
          q.add(new Node(i, j));
        } else if (grid[i][j] == 1) {
          cnt++;
        }
      }
    }

    if (cnt == 0) {
      return 0;
    }

    bfs(grid);

    if (cnt > 0) {
      return -1;
    }

    return answer;
  }

  private static void bfs(int[][] grid) {
    while (!q.isEmpty()) {
      answer++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node now = q.poll();

        for (int d = 0; d < 4; d++) {
          int nx = now.x + dx[d];
          int ny = now.y + dy[d];
          if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
            visited[nx][ny] = true;
            cnt--;
            q.add(new Node(nx, ny));
          }
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
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
  }
}
