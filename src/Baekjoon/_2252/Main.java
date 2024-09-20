package Baekjoon._2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

      map.get(a).add(b);
      table[b]++;
    }

    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (table[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();
      sb.append(now).append(" ");

      for (int next : map.get(now)) {
        table[next]--;
        if (table[next] == 0) {
          q.add(next);
        }
      }
    }

    System.out.println(sb.toString());
  }
}
