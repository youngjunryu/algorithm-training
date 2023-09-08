package Programmers.PCCP2.실습용_로봇;

class Solution {
  public int[] solution(String command) {
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;
    int[] now = new int[2];
    now[0] = 0;
    now[1] = 0;

    for (int i = 0; i < command.length(); i++) {
      char c = command.charAt(i);

      if (c == 'R') {
        d = (d + 1) % 4;
      } else if (c == 'L') {
        if (d == 0) {
          d = 3;
        } else {
          d = d - 1;
        }
      } else if (c == 'G') {
        now[0] += dir[d][0];
        now[1] += dir[d][1];
      } else if (c == 'B') {
        now[0] -= dir[d][0];
        now[1] -= dir[d][1];
      }
    }

    return now;
  }
}
