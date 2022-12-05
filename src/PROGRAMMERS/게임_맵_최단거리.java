package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
  static int n, m;

  public static int solution(int[][] maps) {
    int answer = -1;
    n = maps.length;
    m = maps[0].length;

    bfs(maps);

    if (maps[n-1][m-1] != 1) {
      answer = maps[n-1][m-1];
    }

    return answer;
  }

  private static void bfs(int[][] maps) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 1));
    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;

    int[][] d = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    while (!q.isEmpty()) {
      Node now = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + d[i][0];
        int ny = now.y + d[i][1];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maps[nx][ny] == 0) {
          continue;
        }

        visited[nx][ny] = true;
        maps[nx][ny] = now.value + 1;
        q.add(new Node(nx, ny, now.value + 1));
      }
    }
  }

  static class Node {
    int x;
    int y;
    int value;

    public Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
}
