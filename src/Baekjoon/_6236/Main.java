package Baekjoon._6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int max = -1;
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, arr[i]);
    }

    long left = max;
    long right = 1000000000;

    while (left <= right) {
      long mid = (left + right) / 2;

      int res = calculate(N, arr, mid);

      if (res > M) {
        left = mid + 1;
      } else if (res <= M) {
        right = mid - 1;
      }
    }

    System.out.println(left);
  }

  private static int calculate(int N, int[] arr, long k) {
    int res = 0;

    long store = 0;
    for (int i = 0; i < N; i++) {
      if (store < arr[i]) {
        res++;
        store = k;
      }

      store -= arr[i];
    }

    return res;
  }
}

/*

조절 값: K, 반복적으로 인출하는 금액, 최소로 구해야함
계산 값: res, K로 N일동안의 금액을 사용하기 위해 순회를 돌림

res > M, left = mid + 1
res < M, right = mid - 1
res == M, right = mid - 1

 */