package Baekjoon._1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] table = new int[N + 1];
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      table[b]++;
      map.get(a).add(b);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (table[i] == 0) {
        pq.add(i);
      }
    }

    ArrayList<Integer> result = new ArrayList<>();

    while (!pq.isEmpty()) {
      int now = pq.poll();

      result.add(now);

      for (int next : map.get(now)) {
        table[next]--;

        if (table[next] == 0) {
          pq.add(next);
        }
      }
    }

    for (int n : result) {
      System.out.print(n + " ");
    }
  }
}
