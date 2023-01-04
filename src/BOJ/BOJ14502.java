package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
  static int N, M;
  static int[][] map;
  static ArrayList<int[]> viruses;
  static int max;

  public static void main(String[] args) throws IOException {
    input();
    max = -1;
    checkVirus();
    getWarrier(0);
    System.out.println(max);
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st =new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void checkVirus() {
    viruses = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 2) {
          viruses.add(new int[]{i, j});
        }
      }
    }
  }

  private static void getWarrier(int count) {
    if (count == 3) {
      bfs();
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          getWarrier(count + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static void bfs() {
    int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] virusMap = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        virusMap[i][j] = map[i][j];
      }
    }
    boolean[][] visited = new boolean[N][M];
    Queue<int[]> q = new LinkedList<>(viruses);
    int save = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int dx = cur[0] + d[i][0];
        int dy = cur[1] + d[i][1];

        if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] || virusMap[dx][dy] != 0) {
          continue;
        }

        virusMap[dx][dy] = 2;
        visited[dx][dy] = true;
        q.add(new int[]{dx, dy});
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (virusMap[i][j] == 0) {
          save++;
        }
      }
    }

    max = Math.max(max, save);
  }
}
