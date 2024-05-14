package Baekjoon._17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] arr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    
  }
}
