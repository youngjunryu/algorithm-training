package Programmers.kakao.가장_많이_받은_선물;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

  static int n;
  static HashMap<String, Integer> map = new HashMap<>();
  static int[][] arr;
  static int[] total;
  static int[] result;

  public static int solution(String[] friends, String[] gifts) {
    n = friends.length;
    arr = new int[n + 1][n + 1];
    total = new int[n + 1];
    result = new int[n + 1];

    int idx = 1;
    for (String friend : friends) {
      map.put(friend, idx++);
    }

    for (String gift : gifts) {
      StringTokenizer st = new StringTokenizer(gift);

      String A = st.nextToken();
      String B = st.nextToken();

      int idxA = map.get(A);
      int idxB = map.get(B);

      arr[idxA][idxB]++;
      total[idxA]++;
      total[idxB]--;
    }

    for (int i = 1; i <= n - 1; i++) {
      for (int j = i + 1; j <= n; j++) {
        int valA = arr[i][j];
        int valB = arr[j][i];

        System.out.println(valA + " " + valB);

        if (valA == valB) {
          int val = total[i] - total[j];
          if (val > 0) {
            result[i]++;
          } else if (val < 0) {
            result[j]++;
          }
        } else {
          if (valA > valB) {
            result[i]++;
          } else {
            result[j]++;
          }
        }
      }
    }

    return Arrays.stream(result).max().getAsInt();
  }

  public static void main(String[] args) {
    solution(new String[]{"muzi", "ryan", "frodo", "neo"},
        new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
            "frodo muzi", "frodo ryan", "neo muzi"});
  }
}
