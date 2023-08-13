package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2513 {
  static int N, K, S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> left = new PriorityQueue<>();
    PriorityQueue<Node> right = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int location = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (S > location) {
        left.add(new Node(S - location, num));
      } else {
        right.add(new Node(location - S, num));
      }
    }

    int answer = 0;
    answer += moveBus(left);
    answer += moveBus(right);

    System.out.println(answer);
  }

  private static int moveBus(PriorityQueue<Node> pq) {
    int move = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      int cnt = now.num / K;
      if (now.num % K > 0) {
        cnt++;
      }
      int rem = K * cnt - now.num;
      while (!pq.isEmpty()) {
        Node next = pq.poll();
        if (next.num <= rem) {
          rem -= next.num;
        } else {
          next.num -= rem;
          pq.offer(next);
          break;
        }
      }

      move += (2 * cnt * now.location);
    }

    return move;
  }

  static class Node implements Comparable<Node> {
    int location;
    int num;

    public Node(int location, int num) {
      this.location = location;
      this.num = num;
    }

    @Override
    public int compareTo(Node o) {
      return o.location - this.location;
    }
  }
}
