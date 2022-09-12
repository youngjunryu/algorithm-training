package PROGRAMMERS;

public class 코딩_테스트_공부 {
  public int solution(int alp, int cop, int[][] problems) {
    int goalAlp = -1;
    int goalCop = -1;

    for (int i = 0; i < problems.length; i++) {
      goalAlp = Math.max(goalAlp, problems[i][0]);
      goalCop = Math.max(goalCop, problems[i][1]);
    }

    if (alp >= goalAlp && cop >= goalCop) {
      return 0;
    } else if (alp >= goalAlp) {
      alp = goalAlp;
    } else if (cop >= goalCop){
      cop = goalCop;
    }

    int[][] dp = new int[goalAlp+2][goalCop+2];

    for (int i = alp; i <= goalAlp; i++) {
      for (int j = cop; j <= goalCop; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    dp[alp][cop] = 0;

    for (int i = alp; i <= goalAlp; i++) {
      for (int j = cop; j <= goalCop; j++) {
        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
        dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);

        for (int[] problem : problems) {
          if (i >= problem[0] && j >= problem[1]) {
            if (i + problem[2] > goalAlp && j + problem[3] > goalCop) {
              dp[goalAlp][goalCop] = Math.min(dp[goalAlp][goalCop], dp[i][j] + problem[4]);
            } else if (i + problem[2] > goalAlp) {
              dp[goalAlp][j+problem[3]] = Math.min(dp[goalAlp][j+problem[3]], dp[i][j] + problem[4]);
            } else if (j + problem[3] > goalCop) {
              dp[i+problem[2]][goalCop] = Math.min(dp[i+problem[2]][goalCop], dp[i][j] + problem[4]);
            } else {
              dp[i+problem[2]][j+problem[3]] = Math.min(dp[i+problem[2]][j+problem[3]],
                                                        dp[i][j] + problem[4]);
            }
          }
        }
      }
    }

    return dp[goalAlp][goalCop];
  }
}

/*

answer: 모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단시간

10	10	[[10,15,2,1,2],[20,20,3,3,4]]	15
0	0	[[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]	13

dp[i][j]: 알고력 i와 코딩력 j 상태에 도달하는 데 필요한 최단 시간

 */