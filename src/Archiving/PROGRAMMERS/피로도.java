package Archiving.PROGRAMMERS;

public class 피로도 {
  static int max = -1;

  public static int solution(int k, int[][] dungeons) {
    dfs(k, dungeons, new boolean[dungeons.length]);
    return max;
  }

  private static void dfs(int k, int[][] dungeons, boolean[] visited) {
    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && (k >= dungeons[i][0])) {
        visited[i] = true;
        dfs(k - dungeons[i][1], dungeons, visited);
        visited[i] = false;
      }
    }

    int count = 0;
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] == true) {
        count++;
      }
    }

    max = Math.max(count, max);
  }

  public static void main(String[] args) {
    solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
  }
}
