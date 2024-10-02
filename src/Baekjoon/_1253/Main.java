package Baekjoon._1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long arr[] = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(arr);

    int cnt = 0;
    for (int t = 0; t < N; t++) {
      long num = arr[t];
      int i = 0, j = N - 1;

      while (i < j) {
        if (arr[i] + arr[j] == num) {
          if (i != t && j != t) {
            cnt++;
            break;
          } else if (i == t) { // -arr[K], 0
            i++;
          } else if (j == t) { // 0, arr[K]
            j--;
          }
        } else if (arr[i] + arr[j] < num) {
          i++;
        } else {
          j--;
        }
      }
    }

    System.out.println(cnt);
  }
}
