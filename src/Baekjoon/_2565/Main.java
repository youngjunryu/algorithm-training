package Baekjoon._2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      nodes.add(new Node(a, b));
    }

    Collections.sort(nodes);

    int len = nodes.size();

    ArrayList<Integer> list = new ArrayList<>();

    for (Node node : nodes) {
      int num = node.x;

      int pos = bs(list, num);

      if (pos < list.size()) {
        list.set(pos, num);
      } else {
        list.add(num);
      }
    }

    System.out.println(len - list.size());
  }

  private static int bs(ArrayList<Integer> list, int num) {

    int left = 0;
    int right = list.size() - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (list.get(mid) == num) {
        return mid;
      } else if (list.get(mid) < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
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
