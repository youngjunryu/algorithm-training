package Baekjoon._10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int min = 1000001;
    int max = -1000001;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (min > num) {
        min = num;
      }

      if (max < num) {
        max = num;
      }
    }

    System.out.println(min + " " + max);
  }
}
