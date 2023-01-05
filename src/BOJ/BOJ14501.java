package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] store = new int[N+1][2];
    int[] dp = new int[20];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      store[i][0] = Integer.parseInt(st.nextToken());
      store[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = N; i >= 1; i--) {
      if (store[i][0] > N - i + 1) {
        dp[i] = dp[i+1];
      } else {
        dp[i] = Math.max(dp[i+1], store[i][1] + dp[i + store[i][0]]);
      }
    }

    System.out.println(dp[1]);
  }
}
