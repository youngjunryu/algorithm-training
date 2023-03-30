package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
  static int N;
  static int min = 101;

  public static int solution(int n, int[][] wires) {
    N = n;

    LinkedList<LinkedList<Integer>> map = new LinkedList<>();
    for (int i = 0; i <= n; i++) {
      map.add(new LinkedList<>());
    }

    for (int[] w : wires) {
      int v1 = w[0];
      int v2 = w[1];
      map.get(v1).add(v2);
      map.get(v2).add(v1);
    }

    for (int[] w : wires) {
      Integer v1 = w[0];
      Integer v2 = w[1];
      map.get(v1).remove(v2);
      map.get(v2).remove(v1);
      int cntV1 = bfs(v1, map);
      int cntV2 = bfs(v2, map);
      min = Math.min(min, Math.abs(cntV1 - cntV2));
      map.get(v1).add(v2);
      map.get(v2).add(v1);
    }

    return min;
  }

  private static int bfs(int v, LinkedList<LinkedList<Integer>> map) {
    boolean[] visited = new boolean[N + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    int count = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();
      visited[cur] = true;

      for (int i = 0; i < map.get(cur).size(); i++) {
        int next = map.get(cur).get(i);
        if (visited[next]) {
          continue;
        }

        count++;
        q.add(next);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}});
  }
}
