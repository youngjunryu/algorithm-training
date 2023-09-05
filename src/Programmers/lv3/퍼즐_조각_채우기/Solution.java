package Programmers.lv3.퍼즐_조각_채우기;

import java.util.*;

class Solution {
  int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  int boardSize;
  ArrayList<ArrayList<Point>> emptys = new ArrayList<>();
  ArrayList<ArrayList<Point>> blocks = new ArrayList<>();
  boolean[][] visited;

  public int solution(int[][] game_board, int[][] table) {
    boardSize = game_board.length;
    visited = new boolean[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (game_board[i][j] == 0 && !visited[i][j]) {
          emptys.add(check(game_board, i, j, 0));
        }
      }
    }

    visited = new boolean[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (table[i][j] == 1 && !visited[i][j]) {
          blocks.add(check(table, i, j, 1));
        }
      }
    }

    boolean[] visitedBlocks = new boolean[blocks.size()];
    int answer = 0;

    for (int i = 0; i < emptys.size(); i++) {
      ArrayList<Point> empty = emptys.get(i);
      for (int j = 0; j < blocks.size(); j++) {
        ArrayList<Point> block = blocks.get(j);

        if (empty.size() == block.size() && visitedBlocks[j] == false) {
          if (isRotate(empty, block)) {
            visitedBlocks[j] = true;
            answer += empty.size();
            break;
          }
        }
      }
    }

    return answer;
  }

  private boolean isRotate(ArrayList<Point> empty, ArrayList<Point> block) {
    for (int i = 0; i < 4; i++) {
      int zeroX = block.get(0).x;
      int zeroY = block.get(0).y;

      // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
      for (int j = 0; j < block.size(); j++) {
        block.get(j).x -= zeroX;
        block.get(j).y -= zeroY;
      }

      boolean isCollect = true;

      for (int j = 0; j < empty.size(); j++) {
        Point emptyPoint = empty.get(j);
        Point blockPoint = block.get(j);

        if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
          isCollect = false;
          break;
        }
      }

      if (isCollect) {
        return true;
      }
      else {
        for (int j = 0; j < block.size(); j++) {
          int temp = block.get(j).x;

          block.get(j).x = block.get(j).y;
          block.get(j).y = -temp;
        }

        Collections.sort(block);
      }
    }

    return false;
  }

  private ArrayList<Point> check(int[][] game_board, int i, int j, int type) {
    ArrayList<Point> list = new ArrayList<>();
    Queue<Point> q = new LinkedList<>();

    list.add(new Point(0, 0));
    q.add(new Point(i, j));
    visited[i][j] = true;
    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + d[k][0];
        int ny = p.y + d[k][1];
        if (nx < 0 || nx >= boardSize || ny < 0 || ny >= boardSize) continue;
        if (game_board[nx][ny] == type && !visited[nx][ny]) {
          q.add(new Point(nx, ny));
          list.add(new Point(nx - i, ny - j));
          visited[nx][ny] = true;
        }
      }
    }

    Collections.sort(list);

    return list;
  }

  class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      return x == o.x ? y - o.y : x - o.x;
    }
  }
}
