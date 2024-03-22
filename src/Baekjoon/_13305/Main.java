package Baekjoon._13305;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N]; // 리터당 가격
    int[] b = new int[N - 1]; // 도로의 길이

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N - 1; i++)
      b[i] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      a[i] = Integer.parseInt(st.nextToken());

    long result = 0;
    int minCost = 1000000001;
    for (int i = 0; i < N - 1; i++) {
      minCost = Math.min(minCost, a[i]);
      result += (long)minCost * b[i];
    }

    System.out.println(result);
  }
}

