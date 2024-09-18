package Baekjoon._2623;

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
      int t = Integer.parseInt(st.nextToken());
      int prev = -1;
      for (int j = 0; j < t; j++) {
        int now = Integer.parseInt(st.nextToken());
        if (j == 0) {
          prev = now;
        } else {
          table[now]++;
          map.get(prev).add(now);
          prev = now;
        }
      }
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      if (table[i] == 0) {
        q.add(i);
      }
    }

    ArrayList<Integer> result = new ArrayList<>();

    while (!q.isEmpty()) {
      int now = q.poll();

      result.add(now);

      for (int next : map.get(now)) {
        table[next]--;
        if (table[next] == 0) {
          q.add(next);
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      if (table[i] != 0) {
        System.out.println(0);
        return;
      }
    }

    for (int n : result) {
      System.out.println(n);
    }
  }
}
