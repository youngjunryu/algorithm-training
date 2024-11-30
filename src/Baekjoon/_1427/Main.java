package Baekjoon._1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String str = String.valueOf(N);
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    StringBuilder sb = new StringBuilder(new String(charArray));
    System.out.println(sb.reverse());
  }
}
