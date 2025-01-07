package Baekjoon._9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] arr = new boolean[10001];
    Arrays.fill(arr, true);
    arr[0] = false;
    arr[1] = false;

    for (int i = 2; i * i <= 10000; i++) {
      if (arr[i]) {
        for (int j = i * i; j <= 10000; j += i) {
          arr[j] = false;
        }
      }
    }

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int a = n / 2;
      while (true) {
        int b = n - a;

        if (arr[b] && arr[a]) {
          System.out.println(a + " " + b);
          break;
        } else {
          a--;
        }
      }
    }
  }
}
