package Baekjoon._12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 물품의 수
    int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

    Node[] nodes = new Node[N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken()); // 물품의 무게
      int V = Integer.parseInt(st.nextToken()); // 물품의 가치

      nodes[i] = new Node(W, V);
    }

    // 최대 K 만큼의 무게만을 넣을 수 있음 + 가치합의 최댓값
    int[][] dp = new int[N + 1][K + 1]; // 최대 무게가 k인 가방에서 n번째까지 판단했을 때의 최대 가치

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {
        if (j < nodes[i].weight) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nodes[i].weight] + nodes[i].value);
        }
      }
    }

    System.out.println(dp[N][K]);
  }

  static class Node {

    int weight;
    int value;

    public Node(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
