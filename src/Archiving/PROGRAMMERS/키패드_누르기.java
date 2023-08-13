package Archiving.PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;

public class 키패드_누르기 {
  static Node left;
  static Node right;
  static Map<Integer, Node> map;

  public String solution(int[] numbers, String hand) {
    init();

    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      if (number == 1 || number == 4 || number == 7) {
        left = map.get(number);
        sb.append("L");
      } else if (number == 3 || number == 6 || number == 9) {
        right = map.get(number);
        sb.append("R");
      } else {
        selectHand(number, sb, hand);
      }
    }

    return sb.toString();
  }

  private void selectHand(int number, StringBuilder sb, String hand) {
    Node node = map.get(number);
    int leftDistance = Math.abs(node.x - left.x) + Math.abs(node.y - left.y);
    int rightDistance = Math.abs(node.x - right.x) + Math.abs(node.y - right.y);
    if (leftDistance < rightDistance) {
      left = node;
      sb.append("L");
    } else if (leftDistance > rightDistance){
      right = node;
      sb.append("R");
    } else {
      if (hand.equals("right")) {
        right = node;
        sb.append("R");
      } else {
        left = node;
        sb.append("L");
      }
    }
  }

  private void init() {
    map = new HashMap<>();
    int num = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        map.put(num++, new Node(i, j));
      }
    }
    map.put(10, new Node(3, 0));
    map.put(0, new Node(3, 1));
    map.put(12, new Node(3, 2));

    left = map.get(10);
    right = map.get(12);
  }

  class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
