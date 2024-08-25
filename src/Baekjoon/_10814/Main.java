package Baekjoon._10814;

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
      arr[i] = new Node(i, Integer.parseInt(st.nextToken()), st.nextToken());
    }

    Arrays.sort(arr);
    for (Node node : arr) {
      System.out.println(node.age + " " + node.name);
    }
  }

  static class Node implements Comparable<Node> {

    int idx;
    int age;
    String name;

    public Node(int idx, int age, String name) {
      this.idx = idx;
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo(Node o) {
      if (o.age == this.age) {
        return this.idx - o.idx;
      }

      return this.age - o.age;
    }
  }
}
