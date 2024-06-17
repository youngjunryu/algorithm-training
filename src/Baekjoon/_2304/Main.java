package Baekjoon._2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int result = 0;
    int max = -1;
    int[] arr = new int[1001];
    int left = 1002;
    int right = 0;

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());

      arr[L] = H;

      max = Math.max(H, max);
      left = Math.min(left, L);
      right = Math.max(right, L);
    }

    int now = 0;
    for (int i = 1; i <= 1000; i++) {
      if (arr[i] > 0) {
        if (now < arr[i]) {
          result += now * (i - left);
          now = arr[i];
          left = i;
        }

        if (arr[i] == max) {
          break;
        }
      }
    }

    now = 0;
    for (int i = 1000; i >= 0; i--) {
      if (arr[i] > 0) {
        if (now < arr[i]) {
          result += now * (right - i);
          now = arr[i];
          right = i;
        }
      }

      if (arr[i] == max) {
        break;
      }
    }

    result += (right - left + 1) * max;

    System.out.println(result);
  }
}
