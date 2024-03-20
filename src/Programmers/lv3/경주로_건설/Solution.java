package Programmers.lv3.경주로_건설;

import java.util.*;

public class Solution {
  int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
  int N;
  int[][][] visited;

  class Data {
    int x;
    int y;
    int direction;
    int cost;

    public Data(int x, int y, int direction, int cost) {
      this.x = x;
      this.y = y;
      this.direction = direction;
      this.cost = cost;
    }
  }

  public int solution(int[][] board) {
    int answer = Integer.MAX_VALUE;
    N = board.length;
    visited = new int[N][N][4];

    ArrayDeque<Data> pq = new ArrayDeque<>();
    pq.add(new Data(0, 0, -1, 0));

    while (!pq.isEmpty()) {
      Data cur = pq.poll();

      for (int d = 0; d < 4; d++) {
        int dx = dir[d][0] + cur.x;
        int dy = dir[d][1] + cur.y;

        if (dx < 0 || dy < 0 || dx >= N || dy >= N || board[dx][dy] == 1 || (dx == 0 && dy == 0))
          continue;

        int newCost = calculateCost(d, cur.direction, cur.cost);
        if (dx == N - 1 && dy == N - 1) {
          answer = Math.min(newCost, answer);
        } else if (visited[dx][dy][d] == 0 || visited[dx][dy][d] > newCost) {
          pq.add(new Data(dx, dy, d, newCost));
          visited[dx][dy][d] = newCost;
        }
      }
    }

    return answer;
  }

  private int calculateCost(int newDirection, int prevDirection, int cost) {
    if (prevDirection == -1 || (prevDirection == newDirection))
      return cost + 100;
    return cost + 600;
  }
}

/*

출발점 (0, 0), 도착점 (N-1, N-1)
0은 칸이 비어 있음, 1은 칸이 벽으로 채워져 있음
출발점과 도착점 칸의 원소 값은 항상 0
직선 도로를 만들 때 100원, 코너 만들 때 500원 추가
최소 비용 return


 */