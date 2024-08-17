package Baekjoon._9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      execute(A, B);
    }

    System.out.println(sb);
  }

  private static void execute(int a, int b) {
    String[] dp = new String[10000];
    Arrays.fill(dp, "");

    Queue<Integer> q = new LinkedList<>();
    q.add(a);
    boolean[] visited = new boolean[10000];
    visited[a] = true;

    while (!q.isEmpty()) {
      int now = q.poll();
      String nowConfig = dp[now];

      if (now == b) {
        break;
      }

      // D 명령 처리
      processCommand(nowConfig, dp, q, visited, (now * 2) % 10000, 'D');

      // S 명령 처리
      int sIdx = (now == 0) ? 9999 : now - 1;
      processCommand(nowConfig, dp, q, visited, sIdx, 'S');

      // L 명령 처리
      int lIdx = rotateLeft(now);
      processCommand(nowConfig, dp, q, visited, lIdx, 'L');

      // R 명령 처리
      int rIdx = rotateRight(now);
      processCommand(nowConfig, dp, q, visited, rIdx, 'R');
    }

    sb.append(dp[b]).append("\n");
  }

  private static void processCommand(String nowConfig, String[] dp, Queue<Integer> q,
      boolean[] visited, int newIndex, char command) {
    StringBuilder newConfig = new StringBuilder(nowConfig).append(command);

    if (!visited[newIndex]) {
      dp[newIndex] = newConfig.toString();
      q.add(newIndex);
      visited[newIndex] = true;
    }
  }

  private static int rotateLeft(int n) {
    return n % 1000 * 10 + n / 1000;
  }

  private static int rotateRight(int n) {
    return n % 10 * 1000 + n / 10;
  }
}
