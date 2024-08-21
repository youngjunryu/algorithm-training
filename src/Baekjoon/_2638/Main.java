package Baekjoon._2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static ArrayList<int[]> store;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;

    while (true) {
      if (check(map)) {
        break;
      }

      result++;

      store = new ArrayList<>();
      markOutside(map);

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == 1) {
            int count = 0;
            for (int d = 0; d < 4; d++) {
              int nx = i + dir[d][0];
              int ny = j + dir[d][1];

              if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
              }

              if (map[nx][ny] == -1) {
                count++;
              }
            }

            if (count >= 2) {
              store.add(new int[]{i, j});
            }
          }
        }
      }

      clearMap(map);
    }

    System.out.println(result);
  }

  private static void clearMap(int[][] map) {
    for (int[] s : store) {
      map[s[0]][s[1]] = 0;
    }
    store.clear();
  }

  private static boolean check(int[][] map) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1) {
          return false;
        }
      }
    }
    return true;
  }

  private static void markOutside(int[][] map) {
    Queue<int[]> q = new LinkedList<>();

    map[0][0] = -1;
    q.add(new int[]{0, 0});
    store.add(new int[]{0, 0});

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1 || map[nx][ny] == -1) {
          continue;
        }

        map[nx][ny] = -1;
        q.add(new int[]{nx, ny});
        store.add(new int[]{nx, ny});
      }
    }
  }
}
