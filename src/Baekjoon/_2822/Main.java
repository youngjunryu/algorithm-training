package Baekjoon._2822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Node> list = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      int num = Integer.parseInt(br.readLine());

      list.add(new Node(i + 1, num));
    }

    Collections.sort(list);

    int sum = 0;
    List<Integer> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      sum += list.get(i).val;
      result.add(list.get(i).idx);
    }

    Collections.sort(result);

    System.out.println(sum);

    for (int i = 0; i < 5; i++) {
      System.out.print(result.get(i) + " ");
    }
  }

  static class Node implements Comparable<Node> {

    int idx;
    int val;

    public Node(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }

    @Override
    public int compareTo(Node o) {
      return o.val - this.val;
    }
  }
}
