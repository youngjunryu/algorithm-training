package Baekjoon._15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int R;
  static int Q;
  static ArrayList<ArrayList<Integer>> map;
  static int[] size;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      map.get(u).add(v);
      map.get(v).add(u);
    }

    size = new int[N + 1];

    Node not = new Node(-1, null);
    Node root = new Node(R, not);
    makeTree(root, not);

    for (int i = 0; i < Q; i++) {
      int u = Integer.parseInt(br.readLine());
      System.out.println(size[u]);
    }
  }

  private static void makeTree(Node now, Node parent) {
    size[now.val] = 1;

    for (int next : map.get(now.val)) {
      if (next != parent.val) {
        Node nextNode = new Node(next, now);
        now.childs.add(nextNode);
        makeTree(nextNode, now);
        size[now.val] += size[next];
      }
    }
  }

  static class Node {

    int val;
    Node parent;
    ArrayList<Node> childs;

    public Node(int val, Node parent) {
      this.val = val;
      this.parent = parent;
      childs = new ArrayList<>();
    }
  }
}
