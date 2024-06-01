package Programmers.kakao.도넛과_막대_그래프;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] solution(int[][] edges) {
    int[] answer = {};

    HashMap<Integer, Integer[]> map = new HashMap<>();

    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if (!map.containsKey(a)) {
        map.put(a, new Integer[]{0, 0});
      }
      Integer[] out = map.get(a);
      out[0]++;

      if (!map.containsKey(b)) {
        map.put(b, new Integer[]{0, 0});
      }
      Integer[] in = map.get(b);
      in[1]++;
    }

    int mainOut = 0;
    int main = 0;
    int stick = 0;
    int eight = 0;
    int donut = 0;

    for (Map.Entry<Integer, Integer[]> entrySet : map.entrySet()) {
      int node = entrySet.getKey();
      Integer[] value = entrySet.getValue();
      int out = value[0];
      int in = value[1];

      if (out >= 2 && in == 0) {
        main = node;
        mainOut = out;
      } else if (out == 0 && in >= 1) {
        stick++;
      } else if (out == 2 && in >= 2) {
        eight++;
      }
    }

    donut = mainOut - (stick + eight);

    return new int[]{main, donut, stick, eight};
  }
}

