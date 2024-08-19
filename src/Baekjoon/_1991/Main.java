package Baekjoon._1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static HashMap<String, Node> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    map = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String val = st.nextToken();
      map.put(val, new Node(val, st.nextToken(), st.nextToken()));
    }

    StringBuilder preorderResult = new StringBuilder();
    preorder("A", preorderResult);
    System.out.println(preorderResult);

    StringBuilder inorderResult = new StringBuilder();
    inorder("A", inorderResult);
    System.out.println(inorderResult);

    StringBuilder postorderResult = new StringBuilder();
    postorder("A", postorderResult);
    System.out.println(postorderResult);
  }

  static void preorder(String val, StringBuilder result) {
    if (!map.containsKey(val)) {
      return;
    }

    result.append(val);
    preorder(map.get(val).left, result);
    preorder(map.get(val).right, result);
  }

  static void inorder(String val, StringBuilder result) {
    if (!map.containsKey(val)) {
      return;
    }

    inorder(map.get(val).left, result);
    result.append(val);
    inorder(map.get(val).right, result);
  }

  static void postorder(String val, StringBuilder result) {
    if (!map.containsKey(val)) {
      return;
    }

    postorder(map.get(val).left, result);
    postorder(map.get(val).right, result);
    result.append(val);
  }

  static class Node {

    String val;
    String left;
    String right;

    public Node(String val, String left, String right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
