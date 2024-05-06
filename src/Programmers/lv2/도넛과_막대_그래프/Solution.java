package Programmers.lv2.도넛과_막대_그래프;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] solution(int[][] edges) {
    int[] answer = {};

    HashMap<Integer, Integer[]> map = new HashMap<>();
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if (!map.containsKey(a)) {
        map.put(a, new Integer[]{0, 0});
      }
      Integer[] line = map.get(a);
      line[0] += 1;

      if (!map.containsKey(b)) {
        map.put(b, new Integer[]{0, 0});
      }
      line = map.get(b);
      line[1] += 1;
    }

    int node = -1;
    int nodeOut = 0;
    int stick = 0;
    int eight = 0;
    int donut = 0;

    for (Map.Entry<Integer, Integer[]> entrySet : map.entrySet()) {
      int nodeNum = entrySet.getKey();
      Integer[] line = entrySet.getValue();

      if (line[0] >= 2 && line[1].equals(0)) {
        node = nodeNum;
        nodeOut = line[0];
      } else if (line[0] == 0 && line[1] >= 1) {
        stick++;
      } else if (line[0] == 2 && line[1] >= 2) {
        eight++;
      }
    }

    donut = nodeOut - (stick + eight);

    return new int[]{node, donut, stick, eight};
  }
}


/*

생성된 정점: 나가는 간선의 수 2 이상, 들어오는 간선의 수 0
막대 모양: 나가는 간선의 수가 0, 들어오는 간선의 수 1인 노드의 개수
8자 모양: 나가는 간선의 수가 2, 들어오는 간선의 수 2인 노드의 개수
도넛 모양: 생성된 정점의 나가는 간선의 수 - (막대 모양 그래프 수 + 8자 모양 그래프 수)

 */