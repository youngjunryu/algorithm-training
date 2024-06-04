package Baekjoon._1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    HashMap<Integer, List<Integer[]>> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      if (!map.containsKey(to)) {
        map.put(to, new ArrayList<>());
      }

      List<Integer[]> list = map.get(to);
      list.add(new Integer[]{from, cost});
    }

    int[] dp = new int[D + 1];

    for (int i = 1; i <= D; i++) {
      int val = dp[i - 1] + 1;

      if (map.containsKey(i)) {
        for (Integer[] list : map.get(i)) {
          val = Math.min(val, list[1] + dp[list[0]]);
        }
      }

      dp[i] = val;
    }

    System.out.println(dp[D]);
  }
}
