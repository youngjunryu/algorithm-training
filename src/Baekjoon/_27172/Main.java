package Baekjoon._27172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    int[] order = new int[1000001];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      int val = Integer.parseInt(st.nextToken());
      order[val] = i;
    }

    for (int i = 1; i <= 1000000; i++) {
      if (order[i] != 0) {
        for (int j = i + i; j <= 1000000; j += i) {
          if (order[j] != 0) {
            arr[order[i]]++;
            arr[order[j]]--;
          }
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

/*

시간 복잡도 : O(N log N)

 */
