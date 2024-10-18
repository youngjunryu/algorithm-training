package Baekjoon._19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < M; i++) {
      bs(Integer.parseInt(br.readLine()), nodes);
    }

    System.out.println(sb);
  }

  private static void bs(int n, Node[] nodes) {
    int left = 0;
    int right = nodes.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nodes[mid].num >= n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    sb.append(nodes[left].name).append("\n");
  }

  static class Node {

    String name;
    int num;

    public Node(String name, int num) {
      this.name = name;
      this.num = num;
    }
  }
}
