package Baekjoon._1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int result = 0;

    int left = 0;
    int right = N - 1;

    while (left < right) {
      int sum = arr[left] + arr[right];

      if (sum == M) {
        result++;
        left++;
      } else if (sum > M) {
        right--;
      } else if (sum < M) {
        left++;
      }
    }

    System.out.println(result);
  }
}
