package Baekjoon._1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] cnt = new int[10];

    int N = Integer.parseInt(br.readLine());
    while (N > 0) {
      cnt[N % 10]++;
      N /= 10;
    }

    cnt[6] += cnt[9];
    cnt[6] = cnt[6] % 2 == 0 ? cnt[6] / 2 : cnt[6] / 2 + 1;

    int val = 0;
    for (int i = 0; i < 9; i++) {
      val = Math.max(val, cnt[i]);
    }

    System.out.println(val);
  }
}
