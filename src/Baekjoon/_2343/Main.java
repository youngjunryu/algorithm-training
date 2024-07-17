package Baekjoon._2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    int max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(arr[i], max);
    }

    long sum = Arrays.stream(arr).sum();

    long left = max;
    long right = sum;

    while (left <= right) {
      long mid = (left + right) / 2;

      int cnt = check(arr, mid);

      if (cnt > M) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(left);
  }

  private static int check(int[] arr, long val) {
    int cnt = 0;
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (sum + arr[i] > val) {
        sum = arr[i];
        cnt++;
      } else {
        sum += arr[i];
      }
    }

    if (sum > 0) {
      cnt++;
    }

    return cnt;
  }
}

/*

조절 값: 블루레이 크기 X
계산 값: 블루레이 갯수 CNT

X를 최소로 해야 함

CNT가 많으면, X가 작음
CNT가 적으면, X가 큼

if CNT > M, left = mid + 1
if CNT < M, right = mid - 1
if CNT == M, right = mid - 1

 */
