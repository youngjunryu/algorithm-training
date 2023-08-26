package Programmers.lv2.과제_진행하기;

import java.util.*;

class Solution {
  public String[] solution(String[][] plans) {
    String[] result = new String[plans.length];
    int idx = 0;
    Stack<Node> s = new Stack<>();

    // plan 정렬
    Arrays.sort(plans, (a, b) -> {
      int[] aStart = splitStartTime(a[1]);
      int[] bStart = splitStartTime(b[1]);
      return aStart[0] != bStart[0] ? aStart[0] - bStart[0] : aStart[1] - bStart[1];
    });

    int[] nowTime = splitStartTime(plans[0][1]);
    s.push(new Node(plans[0][0], nowTime[0], nowTime[1], Integer.parseInt(plans[0][2])));
    for (int i = 1; i < plans.length; i++) {
      Node now = s.pop();
      String[] next = plans[i];
      int[] nextTime = splitStartTime(next[1]);
      int k = 0;
      if (nextTime[1] <= nowTime[1]) {
        k += nextTime[1] + 60 - nowTime[1];
        k += (nextTime[0] - 1 - nowTime[0]) * 60;
      } else {
        k += nextTime[1] - nowTime[1];
        k += (nextTime[0] - nowTime[0]) * 60;
      }

      if (k > now.leftTime) { // 진행중이던 과제가 먼저 끝났다면
        result[idx++] = now.name;
        i--;
        if (nowTime[1] + now.leftTime >= 60) {
          nowTime[0]++;
          nowTime[1] = nowTime[1] + now.leftTime - 60;
        } else {
          nowTime[1] = nowTime[1] + now.leftTime;
        }
      } else if (k == now.leftTime) {
        result[idx++] = now.name;
        s.push(new Node(next[0], nextTime[0], nextTime[1], Integer.parseInt(next[2])));
        nowTime[0] = nextTime[0];
        nowTime[1] = nextTime[1];
      } else if (k < now.leftTime) {
        now.updateLeftTime(now.leftTime - k);
        s.push(now);
        s.push(new Node(next[0], nextTime[0], nextTime[1], Integer.parseInt(next[2])));
        nowTime[0] = nextTime[0];
        nowTime[1] = nextTime[1];
      }
    }

    while (!s.isEmpty()) {
      result[idx++] = s.pop().name;
    }

    return result;
  }

  private int[] splitStartTime(String time) {
    String[] s = time.split(":");
    return new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
  }

  class Node {
    String name;
    int startHour;
    int startMinute;
    int leftTime;

    public Node(String name, int h, int m, int t) {
      this.name = name;
      this.startHour = h;
      this.startMinute = m;
      this.leftTime = t;
    }

    public void updateLeftTime(int t) {
      this.leftTime = t;
    }
  }
}
