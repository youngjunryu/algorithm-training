package Archiving.PROGRAMMERS;

public class 비밀지도 {
  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    int[][] map1 = new int[n][n];
    int[][] map2 = new int[n][n];
    init(n, arr1, map1);
    init(n, arr2, map2);

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (map1[i][j] == 0 && map2[i][j] == 0) {
          sb.append(" ");
        } else {
          sb.append("#");
        }
      }

      answer[i] = sb.toString();
    }

    return answer;
  }

  private static void init(int n, int[] arr, int[][] map) {
    for (int i = 0; i < n; i++) {
      String line = Long.toBinaryString(arr[i]);
      if (line.length() < n) {
        StringBuilder sb = new StringBuilder();
        int left = n - line.length();
        while (left-- > 0) {
          sb.append("0");
        }

        sb.append(line);
        line = sb.toString();
      }

      for (int j = 0; j < n; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
  }

  public static void main(String[] args) {
    solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
  }
}
