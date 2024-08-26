package Baekjoon._1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    HashSet<String> set = new HashSet<>();
    LinkedList<Node> list = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      if (set.contains(str)) {
        continue;
      }

      set.add(str);
      list.add(new Node(str));
    }

    Collections.sort(list);

    for (Node n : list) {
      System.out.println(n.str);
    }
  }

  static class Node implements Comparable<Node> {

    String str;

    public Node(String str) {
      this.str = str;
    }

    @Override
    public int compareTo(Node o) {
      if (this.str.length() == o.str.length()) {
        return this.str.compareTo(o.str);
      }

      return this.str.length() - o.str.length();
    }
  }
}
