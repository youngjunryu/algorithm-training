package PROGRAMMERS;

public class 거스름돈 {
  public static int solution(int n, int[] money) {
    int answer = 0;

    int[][] table = new int[money.length + 1][n + 1];
    table[0][0] = 1;
    for (int i = 1; i <= money.length; i++) {
      for (int j = 0; j < money[i-1]; j++) {
        table[i][j] = table[i-1][j];
      }

      for (int j = money[i-1]; j <= n; j++) {
        table[i][j] = (table[i - 1][j] + table[i][j - money[i - 1]]) % 1000000007;
      }
    }

    return table[money.length][n];
  }

  public static void main(String[] args) {
    solution(5, new int[]{1, 2, 5});
  }
}
