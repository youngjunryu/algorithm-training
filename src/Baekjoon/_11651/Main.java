package Baekjoon._11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    Node[] arr = new Node[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(arr);
    for (Node node : arr) {
      System.out.println(node.x + " " + node.y);
    }
  }

  static class Node implements Comparable<Node> {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Node o) {
      if (this.y == o.y) {
        return this.x - o.x;
      }

      return this.y - o.y;
    }
  }
}

