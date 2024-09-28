package Baekjoon._16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int N, M;
  static int[][] board;
  static HashMap<Integer, Integer> hashMap;
  static int[][] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    hashMap = new HashMap<>();
    Queue<int[]> q = new LinkedList<>();
    Queue<int[]> walls = new LinkedList<>();

    result = new int[N][M];
    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        int val = str.charAt(j) - '0';
        board[i][j] = val;

        if (val == 0) {
          q.add(new int[]{i, j});
        } else {
          walls.add(new int[]{i, j});
        }
      }
    }

    getGroup(q);
    calculate(walls);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(result[i][j]);
      }
      System.out.println();
    }
  }

  private static void calculate(Queue<int[]> walls) {
    for (int[] now : walls) {
      HashSet<Integer> set = new HashSet<>();
      int count = 1;
      for (int d = 0; d < 4; d++) {
        int dx = now[0] + dir[d][0];
        int dy = now[1] + dir[d][1];

        if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
          continue;
        }

        int group = board[dx][dy];

        if (group == 1) {
          continue;
        }

        if (set.contains(group)) {
          continue;
        }

        int total = hashMap.get(group);
        count += total % 10;
        set.add(group);
      }

      result[now[0]][now[1]] = count % 10;
    }
  }

  private static void getGroup(Queue<int[]> q) {
    int color = 2;

    for (int[] now : q) {
      if (board[now[0]][now[1]] == 0) {
        int total = paint(now[0], now[1], color);
        hashMap.put(color, total);

        color++;
      }
    }
  }

  private static int paint(int x, int y, int color) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    board[x][y] = color;
    int total = 1;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int dx = now[0] + dir[d][0];
        int dy = now[1] + dir[d][1];

        if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
          continue;
        }

        if (board[dx][dy] == 0) {
          board[dx][dy] = color;
          q.add(new int[]{dx, dy});
          total++;
        }
      }
    }

    return total;
  }
}
