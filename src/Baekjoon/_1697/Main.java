package Baekjoon._1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] dp = new int[1000001];
    Arrays.fill(dp, 10000001);

    dp[N] = 0;

    Queue<Integer> q = new LinkedList<>();
    q.add(N);

    while (!q.isEmpty()) {
      int now = q.poll();

      int minusIdx = now - 1;
      int plusIdx = now + 1;
      int doubleIdx = now * 2;

      int cost = dp[now] + 1;

      if (minusIdx >= 0 && dp[minusIdx] > cost) {
        dp[minusIdx] = cost;
        q.add(minusIdx);
      }

      if (plusIdx <= 1000000 && dp[plusIdx] > cost) {
        dp[plusIdx] = cost;
        q.add(plusIdx);
      }

      if (doubleIdx <= 1000000 && dp[doubleIdx] > cost) {
        dp[doubleIdx] = cost;
        q.add(doubleIdx);
      }
    }

    System.out.println(dp[K]);
  }
}
