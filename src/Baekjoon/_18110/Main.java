package Baekjoon._18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if (n == 0) {
      System.out.println(0);
      return;
    }

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int num = (int) Math.round(n * 0.15);
    Arrays.sort(arr);
    int total = n - (num * 2);
    int sum = 0;
    for (int i = num; i < n - num; i++) {
      sum += arr[i];
    }

    System.out.println(Math.round((float) sum / total));
  }
}
