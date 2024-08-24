package Baekjoon._10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    int[] arr = new int[26];
    Arrays.fill(arr, -1);
    for (int i = 0; i < str.length(); i++) {
      int idx = str.charAt(i) - 'a';
      if (arr[idx] != -1) {
        continue;
      }
      arr[idx] = i;
    }

    for (int a : arr) {
      System.out.print(a + " ");
    }
  }
}
