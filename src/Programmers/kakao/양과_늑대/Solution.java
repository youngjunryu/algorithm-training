package Programmers.kakao.양과_늑대;

import java.util.ArrayList;

public class Solution {
  int size;
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  int max = 0;

  public int solution(int[] info, int[][] edges) {
    size = info.length;

    for (int i = 0 ; i < size; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];

      graph.get(from).add(to);
    }

    ArrayList<Integer> q = new ArrayList<>();
    q.add(0);
    check(0, 0, 0, info, q);

    return max;
  }

  private void check(int idx, int sheep, int wolf, int[] info, ArrayList<Integer> q) {
    if (info[idx] == 0) sheep++;
    else wolf++;

    if (sheep <= wolf) return;
    max = Math.max(max, sheep);

    ArrayList<Integer> list = new ArrayList<>();
    list.addAll(q);
    list.remove(Integer.valueOf(idx));
    list.addAll(graph.get(idx));

    for (int next : list) {
      check(next, sheep, wolf, info, list);
    }
  }
}
