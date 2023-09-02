package Programmers.PCCP1.체육대회;

class Solution {
  int n, total;
  int answer = 0;

  public int solution(int[][] ability) {
    n = ability.length;
    total = ability[0].length;
    boolean[] visited = new boolean[n];

    dfs(ability, visited, 0, 0);

    return answer;
  }

  public void dfs(int[][] ability, boolean[] visited, int cnt, int sum) {
    if (total == cnt) {
      answer = Math.max(sum, answer);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(ability, visited, cnt + 1, sum + ability[i][cnt]);
        visited[i] = false;
      }
    }
  }
}
