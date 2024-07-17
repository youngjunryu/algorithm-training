package Baekjoon._1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    long left = 1;
    long right = (long) Math.pow(N, 2);

    while (left <= right) {
      long mid = (left + right) / 2;
      long idx = 0;
      for (int i = 1; i <= N; i++) {
        idx += Math.min(mid / i, N);
      }

      if (idx < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(left);
  }
}

/*

left = 1
right = 10,000,000,000

조절 값: 오름차순 정렬했을 때 k번째 값 X
계산 값: 오름차순 정렬했을 때 X의 인덱스 IDX

if IDX > k, right = mid - 1
if IDX < k, left = mid + 1
if IDX == k, right = mid - 1

 */
