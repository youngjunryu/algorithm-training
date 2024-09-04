package Baekjoon._17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int R, C, T;
  static int[][] map;
  static Queue<Node> dust;
  static int ax, bx;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[R][C];
    dust = new LinkedList<>();

    boolean flag = true;
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;

        if (val != 0 && val != -1) {
          dust.add(new Node(i, j, val));
        }

        if (flag && val == -1) {
          ax = i;
          bx = i + 1;
          flag = false;
        }
      }
    }

    bfs();

    int result = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        result += map[i][j];
      }
    }
    System.out.println(result);
  }

  private static void bfs() {
    for (int t = 0; t < T; t++) {
      spread();
      sum();
      clean();
      get();
    }
  }

  private static void clean() {
    // 윗부분 공기청정기 반시계방향 순환
    // 위쪽 방향 (좌측 상단)
    for (int i = ax - 1; i > 0; i--) {
      map[i][0] = map[i - 1][0];
    }
    // 왼쪽 방향 (상단)
    for (int i = 0; i < C - 1; i++) {
      map[0][i] = map[0][i + 1];
    }
    // 아래쪽 방향 (우측 상단)
    for (int i = 0; i < ax; i++) {
      map[i][C - 1] = map[i + 1][C - 1];
    }
    // 오른쪽 방향 (좌측 중단)
    for (int i = C - 1; i > 1; i--) {
      map[ax][i] = map[ax][i - 1];
    }
    // 공기청정기에서 나오는 곳은 0으로 설정
    map[ax][1] = 0;

    // 아랫부분 공기청정기 시계방향 순환
    // 아래쪽 방향 (좌측 하단)
    for (int i = bx + 1; i < R - 1; i++) {
      map[i][0] = map[i + 1][0];
    }
    // 왼쪽 방향 (하단)
    for (int i = 0; i < C - 1; i++) {
      map[R - 1][i] = map[R - 1][i + 1];
    }
    // 위쪽 방향 (우측 하단)
    for (int i = R - 1; i > bx; i--) {
      map[i][C - 1] = map[i - 1][C - 1];
    }
    // 오른쪽 방향 (좌측 중단)
    for (int i = C - 1; i > 1; i--) {
      map[bx][i] = map[bx][i - 1];
    }
    // 공기청정기에서 나오는 곳은 0으로 설정
    map[bx][1] = 0;
  }

  private static void get() {
    dust = new LinkedList<>();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] != 0) {
          dust.add(new Node(i, j, map[i][j]));
        }
      }
    }
  }

  private static void sum() {
    map = new int[R][C];

    for (Node now : dust) {
      map[now.x][now.y] += now.cost;
    }
  }

  private static void spread() {
    int size = dust.size();

    for (int i = 0; i < size; i++) {
      Node now = dust.poll();

      int count = 0;
      int amount = (int) Math.floor(now.cost / 5);

      for (int d = 0; d < 4; d++) {
        int nx = now.x + dir[d][0];
        int ny = now.y + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= R || ny >= C || (nx == ax && ny == 0) || (nx == bx
            && ny == 0)) {
          continue;
        }

        count++;
        dust.add(new Node(nx, ny, amount));
      }

      int remain = now.cost - (count * amount);
      dust.add(new Node(now.x, now.y, remain));
    }
  }

  static class Node {

    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }
  }

  private static void print() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
