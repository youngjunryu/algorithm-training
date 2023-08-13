package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 길_찾기_게임 {
  static ArrayList<Node> arrY;
  static ArrayList<Integer> preOrderList;
  static ArrayList<Integer> postOrderList;

  public int[][] solution(int[][] nodeinfo) {
    init(nodeinfo);
    sortY();
    preOrder(arrY);
    postOrder(arrY);

    int[][] answer = new int[2][nodeinfo.length];
    for (int i = 0; i < nodeinfo.length; i++) {
      answer[0][i] = preOrderList.get(i);
      answer[1][i] = postOrderList.get(i);
    }

    return answer;
  }

  private void postOrder(List<Node> arrY) {
    ArrayList<Node> left = new ArrayList<>();
    ArrayList<Node> right = new ArrayList<>();

    Node node = arrY.get(0);
    for (int i = 1; i < arrY.size(); i++) {
      if (node.x > arrY.get(i).x) {
        left.add(arrY.get(i));
      } else {
        right.add(arrY.get(i));
      }
    }

    if (left.size() > 0) {
      postOrder(left);
    }

    if (right.size() > 0) {
      postOrder(right);
    }

    postOrderList.add(node.idx);
  }

  private void preOrder(List<Node> arrY) {
    ArrayList<Node> left = new ArrayList<>();
    ArrayList<Node> right = new ArrayList<>();

    Node node = arrY.get(0);
    for (int i = 1; i < arrY.size(); i++) {
      if (node.x > arrY.get(i).x) {
        left.add(arrY.get(i));
      } else {
        right.add(arrY.get(i));
      }
    }

    preOrderList.add(node.idx);

    if (left.size() > 0) {
      preOrder(left);
    }

    if (right.size() > 0) {
      preOrder(right);
    }
  }

  private void sortY() {
    Collections.sort(arrY, (o1, o2) -> o2.y == o1.y ? o1.x - o2.x : o2.y - o1.y);
  }

  private void init(int[][] nodeinfo) {
    arrY = new ArrayList<>();
    preOrderList = new ArrayList<>();
    postOrderList = new ArrayList<>();

    for (int i = 0; i < nodeinfo.length; i++) {
      Node node = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
      arrY.add(node);
    }
  }

  class Node {
    int x;
    int y;
    int idx;

    public Node(int x, int y, int idx) {
      this.x = x;
      this.y = y;
      this.idx = idx;
    }
  }
}
