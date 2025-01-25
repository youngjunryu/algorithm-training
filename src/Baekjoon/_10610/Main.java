package Baekjoon._10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String N = br.readLine();

    int sum = 0;
    char[] arr = new char[N.length()];

    for (int i = 0; i < N.length(); i++) {
      char c = N.charAt(i);
      arr[i] = c;
      sum += c - '0';
    }

    if (!N.contains("0") || sum % 3 != 0) {
      System.out.println(-1);
      return;
    }

    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for (int i = N.length() - 1; i >= 0; i--) {
      sb.append(arr[i]);
    }
    System.out.println(sb);
  }
}
