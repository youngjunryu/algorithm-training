package Baekjoon._5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Node root = new Node(Integer.parseInt(br.readLine()));

    while (true) {
      String input = br.readLine();

      if (input == null || input.isEmpty() || input.isBlank()) {
        break;
      }

      root.insert(Integer.parseInt(input));
    }

    postOrder(root);
  }

  private static void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.val);
  }

  static class Node {

    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }

    void insert(int n) {
      if (n < this.val) {
        if (this.left == null) {
          this.left = new Node(n);
        } else {
          this.left.insert(n);
        }
      } else {
        if (this.right == null) {
          this.right = new Node(n);
        } else {
          this.right.insert(n);
        }
      }
    }
  }
}
