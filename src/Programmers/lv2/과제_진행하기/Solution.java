package Programmers.lv2.과제_진행하기;

import java.util.*;

class Solution {
  public String[] solution(String[][] plans) {
    String[] result = new String[plans.length];
    int idx = 0;
    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
    Stack<Node> stack = new Stack<>();

    for (String[] p : plans) {
      int[] splitStartTime = splitStartTime(p[1]);
      pq.add(new Node(p[0], splitStartTime[0] * 60 + splitStartTime[1], Integer.parseInt(p[2])));
    }

    stack.add(pq.poll());
    int nowTime = stack.peek().start;

    while (!pq.isEmpty()) {
      Node next = pq.poll();
      Node cur = stack.peek();

      int time = next.start - nowTime;
      if (time == cur.playtime) {
        stack.pop();
        result[idx++] = cur.name;
        stack.add(next);
        nowTime = next.start;
      } else if (time < cur.playtime) {
        cur.updatePlaytime(cur.playtime - time);
        nowTime = next.start;
        stack.add(next);
      } else if (time > cur.playtime) {
        stack.pop();
        result[idx++] = cur.name;
        if (!stack.isEmpty()) {
          nowTime += cur.playtime;
          pq.add(next);
        } else {
          nowTime = next.start;
          stack.add(next);
        }
      }
    }

    while(!stack.isEmpty()) {
      Node cur = stack.pop();
      result[idx++] = cur.name;
    }

    return result;
  }

  private int[] splitStartTime(String time) {
    String[] s = time.split(":");
    return new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
  }

  class Node {
    String name;
    int start;
    int playtime;

    public Node(String name, int start, int playtime) {
      this.name = name;
      this.start = start;
      this.playtime = playtime;
    }

    public void updatePlaytime(int playtime) {
      this.playtime = playtime;
    }
  }
}
