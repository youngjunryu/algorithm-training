package Baekjoon._2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int[][] cost = new int[][]{{0, 2, 2, 2, 2}, {0, 1, 3, 4, 3}, {0, 3, 1, 3, 4},
      {0, 4, 3, 1, 3}, {0, 3, 4, 3, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> inputs = new ArrayList<>();

    while (st.hasMoreTokens()) {
      int c = Integer.parseInt(st.nextToken());

      if (c == 0) {
        break;
      }

      inputs.add(c);
    }

    int[][][] dp = new int[inputs.size()][5][5];
    for (int i = 0; i < inputs.size(); i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          dp[i][j][k] = 400001;
        }
      }
    }

    dp[0][inputs.get(0)][0] = 2;
    dp[0][0][inputs.get(0)] = 2;

    for (int i = 1; i < inputs.size(); i++) {
      int next = inputs.get(i);
      for (int l = 0; l < 5; l++) {
        for (int r = 0; r < 5; r++) {
          if (r != next) {
            dp[i][next][r] = Math.min(dp[i][next][r], dp[i - 1][l][r] + cost[l][next]);
          }

          if (l != next) {
            dp[i][l][next] = Math.min(dp[i][l][next], dp[i - 1][l][r] + cost[r][next]);
          }
        }
      }
    }

    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        answer = Math.min(answer, dp[inputs.size() - 1][i][j]);
      }
    }

    System.out.println(answer);
  }
}
