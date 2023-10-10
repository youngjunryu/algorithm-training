package Baekjoon._14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  static int[][] map;
  static int N, M;
  static int x, y;
  static int[] dice = new int[6];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      int d = Integer.parseInt(st.nextToken()) - 1;
      move(d);
    }
  }

  private static void move(int d) {
    int dx = x + dir[d][0];
    int dy = y + dir[d][1];

    if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
      return;
    }

    process(d, dx, dy);
    x = dx;
    y = dy;
  }

  private static void process(int d, int dx, int dy) {
    int temp = dice[2];
    // dice[2]: 윗면, dice[5]: 아랫면
    // 0: 동, 1: 서, 2: 남, 3: 북
    if (d == 0) {
      dice[2] = dice[3];
      dice[3] = dice[5];
      dice[5] = dice[1];
      dice[1] = temp;
    } else if (d == 1) {
      dice[2] = dice[1];
      dice[1] = dice[5];
      dice[5] = dice[3];
      dice[3] = temp;
    } else if (d == 2) {
      dice[2] = dice[4];
      dice[4] = dice[5];
      dice[5] = dice[0];
      dice[0] = temp;
    } else if (d == 3) {
      dice[2] = dice[0];
      dice[0] = dice[5];
      dice[5] = dice[4];
      dice[4] = temp;
    }

    if (map[dx][dy] == 0) {
      map[dx][dy] = dice[5];
    } else {
      dice[5] = map[dx][dy];
      map[dx][dy] = 0;
    }

    System.out.println(dice[2]);
  }
}
/*
  1
2 3 4
  5
  6
 */
