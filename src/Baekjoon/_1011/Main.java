package Baekjoon._1011;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int dist = y - x;
      System.out.println(solve(dist));
    }
  }

  public static long solve(int d) {
    long answer = 0;

    if (d <= 3) {
      return d;
    }

    for (long n = 1; ; n++) {
      if (n * (n - 1) < d && d <= n * n) {
        answer = 2 * n - 1;
        break;
      }

      if (n * n < d && d <= n * (n + 1)) {
        answer = 2 * n;
        break;
      }
    }
    
    return answer;
  }
}

