package Programmers.kakao.이모티콘_할인행사;

class Solution {
  int len;
  int[] dp;
  int[] max = new int[]{0, 0};

  public int[] solution(int[][] users, int[] emoticons) {
    len = emoticons.length;
    dp = new int[len];


    dfs(0, users, emoticons);

    return max;
  }

  public void dfs(int idx, int[][] users, int[] emoticons) {
    if (idx == len) {
      calculate(users, emoticons);
      return;
    }

    for (int i = 10; i <= 50; i += 10) {
      dp[idx] = i;
      dfs(idx + 1, users, emoticons);
    }
  }

  public void calculate(int[][] users, int[] emoticons) {
    int buyer = 0;
    int revenue = 0;
    int[] emoticonsPrice = new int[len];

    for (int i = 0; i < len; i++) {
      emoticonsPrice[i] = emoticons[i] * (100 - dp[i]) / 100;
    }

    for (int[] user : users) {
      int sum = 0;

      for (int k = 0; k < len; k++) {
        if (dp[k] >= user[0]) {
          sum += emoticons[k] * (100 - dp[k]) / 100;
        }
      }

      if (sum >= user[1]) {
        buyer++;
      } else {
        revenue += sum;
      }
    }

    if (buyer > max[0]) {
      max[0] = buyer;
      max[1] = revenue;
    } else if (buyer == max[0] && revenue > max[1]) {
      max[1] = revenue;
    }
  }
}
