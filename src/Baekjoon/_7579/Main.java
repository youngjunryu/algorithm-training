package Baekjoon._7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // N개의 앱
    // 앱은 m 바이트만큼의 메모리 사용, 재실행하고자 할 경우 c 비용 필요
    // => m 바이트를 확보하기 위해 최소 비용 c의 합

    Node[] nodes = new Node[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nodes[i] = new Node(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nodes[i].setC(Integer.parseInt(st.nextToken()));
    }

    int[][] dp = new int[N + 1][10001]; // i 번째 앱까지 대해서 비용 j로 확보 가능한 최대 메모리
    int result = Integer.MAX_VALUE;

    for (int i = 1; i <= N; i++) {
      int m = nodes[i].m;
      int c = nodes[i].c;

      for (int j = 0; j <= 10000; j++) {
        if (j < c) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + m);
        }

        if (dp[i][j] >= M) {
          result = Math.min(result, j);
        }
      }
    }

    System.out.println(result);
  }

  static class Node {

    int m;
    int c;

    public Node(int m) {
      this.m = m;
    }

    public void setC(int c) {
      this.c = c;
    }
  }
}
