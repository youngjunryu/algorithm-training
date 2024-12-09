package Baekjoon._15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int n, x, y, d, g;
  static boolean[][] map;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int ans = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new boolean[101][101];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());

      drawDragonCurve(x, y, d, g);
    }

    checkSquare();

    System.out.println(ans);
  }

  static void drawDragonCurve(int x, int y, int d, int g) { // 드래곤 커브를 그림
    List<Integer> direction = new ArrayList<>();
    direction.add(d); // 0세대 방향 추가

    for (int i = 1; i < g + 1; i++) { // 방향 추가
      for (int j = direction.size() - 1; j >= 0; j--) {
        direction.add((direction.get(j) + 1) % 4);
      }
    }

    map[y][x] = true; // 시작점 그리기

    for (int dir : direction) { // 담겨진 방향에 맞게 그리기
      x += dx[dir];
      y += dy[dir];

      map[y][x] = true;
    }
  }

  static void checkSquare() {
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
          ans++;
        }
      }
    }
  }
}
