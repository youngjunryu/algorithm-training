package Baekjoon._8960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(br.readLine());

    int[][] arr = new int[M][3];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[i][0] = s;
      arr[i][1] = e;
      arr[i][2] = b;
    }

    Arrays.sort(arr, (a1, a2) -> (a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]));

    int[] available = new int[N + 1];
    Arrays.fill(available, C);

    int res = 0;
    for (int i = 0; i < M; i++) {
      int b = arr[i][2];
      for (int j = arr[i][0]; j < arr[i][1]; j++) {
        b = Math.min(available[j], b);
      }

      if (b > 0) {
        res += b;
        for (int j = arr[i][0]; j < arr[i][1]; j++) {
          available[j] -= b;
        }
      }
    }

    System.out.println(res);
  }
}

/*

30 + 60 + 60
1 2 30 / 30
2 5 70 / 60
5 6 60 / 60

1 2 30
3 4 40
2 5 70
1 6 40
5 6 60

30 + 40 + 20 + 60

30
30 0 40
30 20 60 20
30 20 60 20 60


10 + 30 + 30
1 2 10 + 1 3 20 + 1 4 10 / 40
2 3 10 / 40
3 4 20 / 30

1 2 10
1 3 20
2 3 10
1 4 30
2 4 20
3 4 20

 */