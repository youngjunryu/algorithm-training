package PROGRAMMERS;

public class 삼각_달팽이 {
  public static int[] solution(int n) {
    int[] answer = new int[n * (n + 1) / 2];
    int[][] tree = new int[n][n];
    int num = 1;
    int x = -1;
    int y = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (i % 3 == 0) {
          x++;
        } else if (i % 3 == 1) {
          y++;
        } else if (i % 3 == 2) {
          x--;
          y--;
        }

        tree[x][y] = num++;
      }
    }

    int idx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (tree[i][j] != 0) {
          answer[idx] = tree[i][j];
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(6);
  }
}
