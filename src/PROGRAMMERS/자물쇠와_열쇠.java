package PROGRAMMERS;

public class 자물쇠와_열쇠 {
  public static boolean solution(int[][] key, int[][] lock) {
    int n = key.length;
    int m = lock.length;

    int[][] map = new int[n * 2 + m - 2][n * 2 + m - 2];

    for (int i = n - 1; i < n + m - 1; i++) {
      for (int j = n - 1; j < n + m - 1; j++) {
        map[i][j] = lock[i - (n - 1)][j - (n - 1)];
      }
    }

    for (int i = 0; i <= 5; i++) {
      if (match(map, key, m)) {
        return true;
      }
      key = turn(key);
    }

    return false;
  }

  private static boolean match(int[][] map, int[][] key, int m) {
    int keyLen = key.length;
    int mapLen = map.length;

    for (int i = 0; i < mapLen - keyLen + 1; i++) {
      for (int j = 0; j < mapLen - keyLen + 1; j++) {
        for (int k = 0; k < keyLen; k++) {
          for (int l = 0; l < keyLen; l++) {
            map[i+k][j+l] += key[k][l];
          }
        }

        boolean flag = true;
        for (int k = keyLen - 1; k < keyLen + m - 1; k++) {
          for (int l = keyLen - 1; l < keyLen + m - 1; l++) {
            if (map[k][l] != 1) {
              flag = false;
              break;
            }
          }

          if (!flag) {
            break;
          }
        }

        if (flag) {
          return true;
        }

        for (int k = 0; k < keyLen; k++) {
          for (int l = 0; l < keyLen; l++) {
            map[i+k][j+l] -= key[k][l];
          }
        }
      }
    }

    return false;
  }

  public static int[][] turn(int[][] key) {
    int len = key.length;

    int[][] turnArr = new int[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        turnArr[j][len - i - 1] = key[i][j];
      }
    }

    return turnArr;
  }

  public static void main(String[] args) {
    boolean solution = solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
  }
}
