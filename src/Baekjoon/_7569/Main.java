package Baekjoon._7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  static int M, N, H;
  static int[][][] map;
  static int result;
  static int[][] dir = new int[][]{
      {1, 0, 0},   // 위로 이동
      {-1, 0, 0},  // 아래로 이동
      {0, 1, 0},   // 오른쪽으로 이동
      {0, -1, 0},  // 왼쪽으로 이동
      {0, 0, 1},   // 앞으로 이동
      {0, 0, -1}   // 뒤로 이동
  };
  static ArrayDeque<int[]> deque;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][N][M];
    deque = new ArrayDeque<>();

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int z = 0; z < M; z++) {
          int val = Integer.parseInt(st.nextToken());
          map[i][j][z] = val;
          if (val == 1) {
            deque.add(new int[]{i, j, z});
          }
        }
      }
    }

    result = 0;

    while (true) {
      int loop = deque.size();

      if (deque.isEmpty()) {
        break;
      }

      if (check()) {
        break;
      }

      for (int i = 0; i < loop; i++) {
        int[] now = deque.pollFirst();

        for (int d = 0; d < 6; d++) {
          int dz = now[0] + dir[d][0];
          int dx = now[1] + dir[d][1];
          int dy = now[2] + dir[d][2];

          if (dz < 0 || dx < 0 || dy < 0 || dz >= H || dx >= N || dy >= M) {
            continue;
          }

          if (map[dz][dx][dy] == 0) {
            map[dz][dx][dy] = 1;
            deque.addLast(new int[]{dz, dx, dy});
          }
        }
      }

      result++;
    }

    if (!check()) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
  }

  private static boolean check() {
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int z = 0; z < M; z++) {
          if (map[i][j][z] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
