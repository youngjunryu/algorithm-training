package Baekjoon._2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] solutions = new int[N];
    for (int i = 0; i < N; i++) {
      solutions[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(solutions);

    int left = 0;
    int right = N - 1;
    int min = Integer.MAX_VALUE;
    int result1 = -1;
    int result2 = -1;

    while (left < right) {
      int leftVal = solutions[left];
      int rightVal = solutions[right];

      int sum = leftVal + rightVal;

      if (Math.abs(sum) < min) {
        min = Math.abs(sum);
        result1 = solutions[left];
        result2 = solutions[right];
      }

      if (sum == 0) {
        break;
      }

      if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }

    System.out.println(result1 + " " + result2);
  }
}
