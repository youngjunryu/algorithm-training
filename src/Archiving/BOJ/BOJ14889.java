package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
  static int N;
  static int[][] strength;
  static int min = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    strength = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        strength[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    backtracking(0, 0, new boolean[N]);
    System.out.println(min);
  }

  private static void backtracking(int cur, int count, boolean[] visited) {
    if (count == N / 2) {
      min = Math.min(min, calculateTeam(visited));
      return;
    }

    for (int i = cur; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        backtracking(i + 1, count + 1, visited);
        visited[i] = false;
      }
    }
  }

  private static int calculateTeam(boolean[] visited) {
    int startSum = 0;
    int linkSum = 0;
    int[] start = new int[N/2];
    int[] link = new int[N/2];
    int startIdx = 0;
    int linkIdx = 0;
    for (int i = 0; i < N; i++) {
      if (visited[i]) {
        start[startIdx++] = i;
      } else {
        link[linkIdx++] = i;
      }
    }

    for (int i = 0; i < N / 2; i++) {
      for (int j = i +  1; j < N / 2; j++) {
        startSum += strength[start[i]][start[j]];
        startSum += strength[start[j]][start[i]];
        linkSum += strength[link[i]][link[j]];
        linkSum += strength[link[j]][link[i]];
      }
    }

    return Math.abs(startSum - linkSum);
  }
}
