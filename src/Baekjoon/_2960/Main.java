package Baekjoon._2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    int count = 0;
    for (int i = 2; i <= N; i++) {
      if (isPrime[i]) {
        for (int j = i; j <= N; j += i) {
          if (!isPrime[j]) {
            continue; // 이미 지워진 경우 패스
          }
          isPrime[j] = false;
          count++;
          if (count == K) {
            System.out.println(j);
            return;
          }
        }
      }
    }

  }
}
