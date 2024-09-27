package Baekjoon._16724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static char[][] map;
  static int[][] paint;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    paint = new int[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    int count = 0;
    int idx = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (paint[i][j] == 0) {
          boolean isUnion = dfs(i, j, idx);
          if (!isUnion) {
            count++;
            idx++;
          }
        }
      }
    }

    System.out.println(count);
  }

  private static boolean dfs(int x, int y, int color) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{x, y});

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});

    paint[x][y] = -1;
    int union = -1;

    while (!stack.isEmpty()) {
      int[] now = stack.pop();

      char c = map[now[0]][now[1]];
      int dx = 0, dy = 0;
      if (c == 'D') {
        dx = now[0] + 1;
        dy = now[1];
      } else if (c == 'L') {
        dx = now[0];
        dy = now[1] - 1;
      } else if (c == 'U') {
        dx = now[0] - 1;
        dy = now[1];
      } else {
        dx = now[0];
        dy = now[1] + 1;
      }

      if (paint[dx][dy] == 0) {
        q.add(new int[]{dx, dy});
        paint[dx][dy] = -1;
        stack.push(new int[]{dx, dy});
      } else if (paint[dx][dy] != 0) {
        union = paint[dx][dy];
      }
    }

    if (union == -1) {
      print(q, color);
      return false;
    } else {
      print(q, union);
      return true;
    }
  }

  private static void print(Queue<int[]> q, int union) {
    for (int[] n : q) {
      paint[n[0]][n[1]] = union;
    }
  }
}
