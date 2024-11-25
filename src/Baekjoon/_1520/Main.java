package Baekjoon._1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int M, N;
  static int[][] map;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    dp = new int[M][N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1; // 아직 계산되지 않은 상태
      }
    }

    System.out.println(dfs(0, 0));
  }

  private static int dfs(int x, int y) {
    // 도착점에 도달하면 경로 하나를 발견했으므로 1 반환
    if (x == M - 1 && y == N - 1) {
      return 1;
    }

    // 이미 계산된 경우 저장된 값을 반환
    if (dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 0; // 현재 위치에서 출발하는 경로 수 초기화

    for (int d = 0; d < 4; d++) {
      int nx = x + dir[d][0];
      int ny = y + dir[d][1];

      // 유효한 범위 내에서 탐색하며, 낮은 높이로만 이동
      if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[x][y] > map[nx][ny]) {
        dp[x][y] += dfs(nx, ny); // 재귀 호출로 경로 수 누적
      }
    }

    return dp[x][y]; // 현재 위치에서 가능한 모든 경로 수 반환
  }
}
