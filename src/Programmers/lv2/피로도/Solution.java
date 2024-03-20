package Programmers.lv2.피로도;

import java.util.*;

class Solution {
  int N;
  int answer = -1;

  public int solution(int k, int[][] dungeons) {
    N = dungeons.length;
    backtracking(dungeons, k, new boolean[N], 0);
    return answer;
  }

  public void backtracking(int[][] dungeons, int remain, boolean[] visited, int cnt) {
    for (int i = 0; i < N; i++) {
      if (!visited[i] && remain >= dungeons[i][0]) {
        visited[i] = true;
        backtracking(dungeons, remain - dungeons[i][1], visited, cnt + 1);
        answer = Math.max(answer, cnt + 1);
        visited[i] = false;;
      }
    }
  }
}
