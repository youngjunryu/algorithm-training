package Baekjoon._19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    String str = br.readLine();
    for (int i = 0; i < N; i++) {
      if (str.charAt(i) == 'H') {
        arr[i] = 1;
      } else {
        arr[i] = 2;
      }
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i] != 2) {
        continue;
      }

      boolean isEatLeft = false;
      for (int j = i - K; j < i; j++) {
        if (j < 0) {
          continue;
        }

        if (arr[j] == 1) {
          isEatLeft = true;
          arr[j] = -1;
          result++;
          break;
        }
      }

      if (!isEatLeft) {
        for (int j = i + 1; j <= i + K; j++) {
          if (j >= N) {
            break;
          }

          if (arr[j] == 1) {
            arr[j] = -1;
            result++;
            break;
          }
        }
      }
    }

    System.out.println(result);
  }
}
