package Baekjoon._9527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static long[] dp = new long[55];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    calculateDP();
    long result = countOnesInRange(B) - countOnesInRange(A - 1);
    System.out.print(result);
  }

  static long countOnesInRange(long n) {
    long count = n & 1;
    int size = (int) (Math.log(n) / Math.log(2));
    for (int i = size; i > 0; i--) {
      if ((n & (1L << i)) != 0L) {
        count += dp[i - 1] + (n - (1L << i) + 1);
        n -= (1L << i);
      }
    }
    return count;
  }

  static void calculateDP() {
    dp[0] = 1;
    for (int i = 1; i < 55; i++) {
      dp[i] = (dp[i - 1] << 1) + (1L << i);
    }
  }
}

/*


2: 10
3: 11
4: 100
5: 101
6: 110
7: 111
8: 1000
9: 1001
10: 1010
11: 1011
12: 1100
13: 1101
14: 1110
15: 1111
16: 10000
17: 10001
18: 10010
19: 10011
20: 10100
21: 10101


*/