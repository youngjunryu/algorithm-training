package Baekjoon._1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      pq.add(new Node(start, end));
    }

    int result = 1;
    int endTime = pq.poll().end;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.start < endTime) {
        continue;
      }

      endTime = now.end;
      result++;
    }

    System.out.println(result);
  }

  static class Node implements Comparable<Node> {

    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Node o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }
      return this.end - o.end;
    }
  }
}
