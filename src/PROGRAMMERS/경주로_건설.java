package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {
  static int[][][] cost;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static int min = Integer.MAX_VALUE;

  public static int solution(int[][] board) {
    int answer = min;
    int N = board.length;
    cost = new int[4][N][N];

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 1, 0));
    cost[1][0][0] = 0;
    q.add(new Node(0, 0, 2, 0));
    cost[2][0][0] = 0;

    for (int d = 0; d < 4; d++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          cost[d][i][j] = min;
        }
      }
    }

    while (!q.isEmpty()) {
      Node n = q.poll();

      if (n.curX == N - 1 && n.curY == N - 1) {
        answer = Math.min(n.cost, answer);
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int nextX = n.curX + dx[i];
        int nextY = n.curY + dy[i];

        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || board[nextX][nextY] == 1) {
          continue;
        }

        int nextCost = n.cost + 100;
        if (n.dir != i) {
          nextCost += 500;
        }

        if (nextCost <= cost[i][nextX][nextY]) {
          cost[i][nextX][nextY] = nextCost;
          q.add(new Node(nextX, nextY, i, nextCost));
        }
      }
    }

    return answer;
  }

  static class Node {
    int curX;
    int curY;
    int dir;
    int cost;

    public Node(int curX, int curY, int dir, int cost) {
      this.curX = curX;
      this.curY = curY;
      this.dir = dir;
      this.cost = cost;
    }
  }

  public static void main(String[] args) {
    solution(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}});
  }
}
