package Baekjoon._1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] idx = new int[N + 1];
    int[] count = new int[N + 1];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      boolean flag = true;
      while (st.hasMoreElements()) {
        int val = Integer.parseInt(st.nextToken());

        if (val == -1) {
          break;
        }

        if (flag) {
          idx[i] = val;
          flag = false;
          continue;
        }

        count[i]++;
        graph.get(val).add(i);
      }
    }

    int[] result = new int[N + 1];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      if (count[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int num = queue.poll();

      result[num] += idx[num];

      List<Integer> list = graph.get(num);

      for (int i = 0; i < list.size(); i++) {
        count[list.get(i)]--;
        result[list.get(i)] = Math.max(result[list.get(i)], result[num]);
        if (count[list.get(i)] == 0) {
          queue.add(list.get(i));
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      System.out.println(result[i]);
    }
  }
}
