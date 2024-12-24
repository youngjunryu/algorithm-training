package Baekjoon._4948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static boolean[] isPrime;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int limit = 123456 * 2;
    isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);

    // 소수 계산
    go(limit);

    // 누적합 계산
    int[] sum = new int[limit + 1];
    for (int i = 1; i <= limit; i++) {
      sum[i] = sum[i - 1] + (isPrime[i] ? 1 : 0);
    }

    // 입력 처리
    while (true) {
      String line = br.readLine();
      if (line == null || line.equals("0")) {
        break;
      }

      int n = Integer.parseInt(line);
      int result = sum[n * 2] - sum[n];
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }

  public static void go(int limit) {
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= limit; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }
}
