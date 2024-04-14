package Baekjoon._1138;

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
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] ans = new int[N];

    for (int i = 0; i < N; i++) {
      int idx = i + 1;
      int largeSum = arr[i];

      int cnt = 0;
      for (int j = 0; j < N; j++) {
        if (ans[j] == 0 && cnt == largeSum) {
          ans[j] = idx;
          break;
        }

        if (ans[j] == 0) {
          cnt++;
        }
      }
    }

    Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
  }
}
