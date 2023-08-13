package Archiving.PROGRAMMERS.simul.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three {
  public int[] solution(String[] grid) {
    int[] ans;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int n = grid.length;
    int m = grid[0].length();
    boolean[][][] visited = new boolean[n][m][4];
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int d = 0; d < 4; d++) {
          int cnt = 0 ;
          int x = i;
          int y = j;
          int k = d;

          while (!visited[x][y][k]) {
            visited[x][y][k] = true;
            cnt++;

            char now = grid[x].charAt(y);

            if (now == 'R') {
              k = (k + 1 + 4) % 4;
            } else if (now == 'L'){
              k = (k - 1 + 4) % 4;
            }

            x = (x + dx[k] + n) % n;
            y = (y + dy[k] + m) % m;

            if (x == i && y == j && d == k) {
              result.add(cnt);
              break;
            }
          }
        }
      }
    }

    ans = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }

    Arrays.sort(ans);

    return ans;
  }
}
