package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1448 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = -1;

    int N = Integer.parseInt(br.readLine());
    Integer[] len = new Integer[N];
    for (int i = 0; i < N; i++) {
      len[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(len, Collections.reverseOrder());

    int big = 0;
    while (big < N - 2) {
      if (len[big] >= len[big + 1] + len[big + 2]) {
        big++;
        continue;
      }

      answer = Math.max(answer, len[big] + len[big + 1] + len[big + 2]);
      big++;
    }

    System.out.println(answer);
  }
}
