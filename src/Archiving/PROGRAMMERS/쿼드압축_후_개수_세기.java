package Archiving.PROGRAMMERS;

public class 쿼드압축_후_개수_세기 {
  static int zero = 0;
  static int one = 0;

  public static int[] solution(int[][] arr) {
    compress(0, 0, arr.length, arr);

    return new int[]{zero, one};
  }

  public static void compress(int n, int m, int size, int[][] arr) {
    int count = size * size;
    int oneCnt = 0;
    int zeroCnt = 0;
    for (int i = n; i < n + size; i++) {
      for (int j = m; j < m + size; j++) {
        if (arr[i][j] == 1) {
          oneCnt++;
        } else {
          zeroCnt++;
        }
      }
    }

    if (oneCnt == count) {
      one++;
      return;
    }

    if (zeroCnt == count) {
      zero++;
      return;
    }

    if (size / 2 == 0) {
      return;
    }

    compress(n, m, size / 2, arr);
    compress(n + size / 2, m, size / 2, arr);
    compress(n, m + size / 2, size / 2, arr);
    compress(n + size / 2, m + size / 2, size / 2, arr);
  }

  public static void main(String[] args) {
    solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
  }
}
