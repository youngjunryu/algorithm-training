package Baekjoon._1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int val = Integer.parseInt(br.readLine());
      pq.add(val);
    }

    int result = 0;
    while (pq.size() != 1) {
      int a = pq.poll();
      int b = pq.poll();

      int sum = a + b;
      pq.add(sum);
      result += sum;
    }

    System.out.println(result);
  }
}

