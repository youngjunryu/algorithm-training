package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class 행렬_테두리_회전하기 {
  static int[][] map;

  public static int[] solution(int rows, int columns, int[][] queries) {
    init(rows, columns);
    return getAnswer(queries);
  }

  private static int[] getAnswer(int[][] queries) {
    List<Integer> answerList = new ArrayList<>();
    int[] answer;

    for (int[] query : queries) {
      int x = query[0];
      x--;

      int y = query[1];
      y--;

      int xx = query[2];
      xx--;

      int yy = query[3];
      yy--;

      answerList.add(turnMap(x, y, xx, yy));
    }

    answer = new int[answerList.size()];

    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

  private static int turnMap(int x, int y, int xx, int yy) {
    int temp = map[x][y];
    int min = temp;

    for (int i = x; i < xx; i++) {
      min = Math.min(min, map[i][y]);
      map[i][y] = map[i+1][y];
    }

    for (int i = y; i < yy; i++) {
      min = Math.min(min, map[xx][i]);
      map[xx][i] = map[xx][i+1];
    }

    for (int i = xx; i > x; i--) {
      min = Math.min(min, map[i][yy]);
      map[i][yy] = map[i-1][yy];
    }

    for (int i = yy; i > y; i--) {
      min = Math.min(min, map[x][i]);
      map[x][i] = map[x][i-1];
    }

    map[x][y+1] = temp;

    return min;
  }

  private static void init(int rows, int columns) {
    map = new int[rows][columns];
    int num = 1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        map[i][j] = num++;
      }
    }
  }
}
