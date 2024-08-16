package Baekjoon._16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    for (int j = 0; j < M; j++) {
      st = new StringTokenizer(br.readLine());
      map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Queue<Integer> queue = new LinkedList<>();
    int[] dp = new int[101];

    Arrays.fill(dp, 0);

    dp[1] = 0;
    queue.add(1);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (map.containsKey(now)) {
        int idx = map.get(now);
        int cost = dp[now];
        execute(dp, idx, cost, queue);
      } else {
        for (int i = 1; i <= 6; i++) {
          int idx = now + i;
          int cost = dp[now] + 1;

          if (idx > 100) {
            break;
          }

          execute(dp, idx, cost, queue);
        }
      }
    }

    System.out.println(dp[100]);
  }

  private static void execute(int[] dp, int idx, int cost, Queue<Integer> queue) {
    if (dp[idx] == 0) {
      dp[idx] = cost;
      queue.add(idx);
    } else if (dp[idx] > cost) {
      dp[idx] = cost;
      queue.add(idx);
    }
  }
}
