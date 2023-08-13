package Archiving.LEETCODE;

public class Best_Time_to_Buy_and_Sell_Stock {
  public int maxProfit(int[] prices) {
    int min = 10001;
    int max = 0;

    for (int i = 0; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      max = Math.max(max, prices[i] - min);
    }

    return max;
  }
}

/*

7 1 5 3 6 4
0 1 2 3 4 5


 */