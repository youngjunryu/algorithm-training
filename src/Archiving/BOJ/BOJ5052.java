package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5052 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine();
      }

      Arrays.sort(arr);

      if(isConsistency(n, arr)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static boolean isConsistency(int n, String[] arr) {
    for (int i = 1; i < n; i++) {
      if (arr[i].startsWith(arr[i-1])) {
        return false;
      }
    }

    return true;
  }
}
