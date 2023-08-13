package Archiving.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    for (int i = 0; i < places.length; i++) {
      boolean flag = true;
      String[] place = places[i];
      for (int j = 0; j < place.length && flag; j++) {
        for (int k = 0; k < place[j].length() && flag; k++) {
          if (place[j].charAt(k) == 'P') {
            if (!bfs(place, j, k)) {
              flag = false;
            }
          }
        }
      }

      answer[i] = flag ? 1 : 0;
    }

    return answer;
  }

  private boolean bfs(String[] place, int x, int y) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(x, y));

    while (!q.isEmpty()) {
      Node now = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (nx == x && ny == y)) {
          continue;
        }

        int d = Math.abs(nx - x) + Math.abs(ny - y);

        if (d <= 1 && place[nx].charAt(ny) == 'X') {
          continue;
        } else if (d <= 1 && place[nx].charAt(ny) == 'O') {
          q.add(new Node(nx, ny));
        } else if (d <= 2 && place[nx].charAt(ny) == 'P') {
          return false;
        }
      }
    }

    return true;
  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
