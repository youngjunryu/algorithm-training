package Baekjoon._2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int sum = 0;
    while (st.hasMoreTokens()) {
      int val = Integer.parseInt(st.nextToken());
      sum += Math.pow(val, 2);
    }

    System.out.println(sum % 10);
  }
}
