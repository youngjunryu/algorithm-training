package Baekjoon._1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Integer[] bags = new Integer[K];
    for (int i = 0; i < K; i++) {
      int c = Integer.parseInt(br.readLine());
      bags[i] = c;
    }

    Arrays.sort(bags);
    Arrays.sort(nodes, Comparator.comparingInt(a -> a.weight));

    long result = 0;
    int idx = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.price - a.price);
    for (int i = 0; i < K; i++) {
      int bag = bags[i];

      int j = idx;
      if (idx < N) {
        while (j < N && nodes[j].weight <= bag) {
          pq.add(nodes[j]);
          j++;
        }
      }

      idx = j;
      if (!pq.isEmpty()) {
        Node avail = pq.poll();
        result += avail.price;
      }
    }

    System.out.println(result);
  }

  static class Node {

    int weight;
    int price;

    public Node(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }
  }
}
