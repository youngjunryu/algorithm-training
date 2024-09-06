package Baekjoon._12581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    min = 100001;

    if (N == K) {
      System.out.println(0 + " " + 1);
      return;
    }

    int[] dist = new int[100001];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[N] = 0;

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{N, 0});
    ArrayList<Integer> results = new ArrayList<>();

    while (!q.isEmpty()) {
      int[] now = q.poll();

      int minus = now[0] - 1;
      int plus = now[0] + 1;
      int two = now[0] * 2;

      if (minus >= 0) {
        if (dist[minus] >= now[1] + 1) {
          if (minus != K) {
            dist[minus] = now[1] + 1;
            q.add(new int[]{minus, now[1] + 1});
          } else {
            results.add(now[1] + 1);
          }
        }
      }

      if (plus <= 100000) {
        if (dist[plus] >= now[1] + 1) {
          if (plus != K) {
            dist[plus] = now[1] + 1;
            q.add(new int[]{plus, now[1] + 1});
          } else {
            results.add(now[1] + 1);
          }
        }
      }

      if (two <= 100000) {
        if (dist[two] >= now[1] + 1) {
          if (two != K) {
            dist[two] = now[1] + 1;
            q.add(new int[]{two, now[1] + 1});
          } else {
            results.add(now[1] + 1);
          }
        }
      }
    }

    Collections.sort(results);
    int a = results.get(0);
    int b = 0;
    for (int result : results) {
      if (result == a) {
        b++;
      }
    }

    System.out.println(a + " " + b);
  }
}

/*

5 4 8 16 17
5 10 9 18 17

 */