package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11509 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    int[] arr = new int[1000002];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int h = Integer.parseInt(st.nextToken());

      if (arr[h+1] == 0) {
        ans++;
      } else {
        arr[h+1]--;
      }

      arr[h]++;
    }

    System.out.println(ans);
  }
}
