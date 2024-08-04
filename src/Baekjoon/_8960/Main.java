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

1. 받는 마을 번호로 정렬. Why? 순회하면서 차례대로 실을 수 있는 박스를 최대한 실어주기 위해
2. available 배열 선언. 각 마을에서 더 실을 수 있는 박스의 갯수 저장
3. 정렬된 배열을 순회하면서 실을 수 있는 최대 갯수를 실어준다.

 */