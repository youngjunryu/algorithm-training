package Baekjoon._2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 접시 수
    int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
    int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
    int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

    int result = -1;

    int[] sushi = new int[N];
    for (int i = 0; i < N; i++) {
      sushi[i] = Integer.parseInt(br.readLine());
    }

    int[] category = new int[d + 1];
    int max = 0;

    for (int i = 0; i < k; i++) {
      int value = sushi[i];
      category[value]++;
    }

    for (int i = 0; i <= d; i++) {
      if (category[i] >= 1) {
        max++;
      }

      if (i == c && category[i] >= 1) {
        max--;
      }
    }

    result = Math.max(result, max);

    for (int left = 1; left < N; left++) {
      int l = sushi[left - 1];
      int right = (left + k - 1) % N;
      int r = sushi[right];

      category[l]--;
      if (category[l] == 0) {
        max--;

        if (l == c) {
          max++;
        }
      }

      category[r]++;
      if (category[r] == 1) {
        max++;

        if (r == c) {
          max--;
        }
      }

      result = Math.max(result, max);
    }

    System.out.println(result + 1);
  }
}
