package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도_여행 {
  static ArrayList<Integer> result = new ArrayList<>();
  static boolean[][] visited;
  static char[][] map;

  public static int[] solution(String[] maps) {
    map = new char[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        map[i][j] = maps[i].charAt(j);
      }
    }

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        if (map[i][j] != 'X' && !visited[i][j]) {
          result.add(bfs(i, j));
        }
      }
    }

    if (result.size() == 0) {
      return new int[]{-1};
    } else {
      int[] answer = new int[result.size()];
      Collections.sort(result);
      for (int i = 0; i < result.size(); i++) {
        answer[i] = result.get(i);
      }
      return answer;
    }
  }

  private static Integer bfs(int x, int y) {
    int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    int count = map[x][y] - '0';
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int dx = cur[0] + d[i][0];
        int dy = cur[1] + d[i][1];

        if (dx >= 0 && dy >= 0 && dx < map.length && dy < map[0].length && !visited[dx][dy] && map[dx][dy] != 'X') {
          count += map[dx][dy] - '0';
          visited[dx][dy] = true;
          q.add(new int[]{dx, dy});
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
  }
}
