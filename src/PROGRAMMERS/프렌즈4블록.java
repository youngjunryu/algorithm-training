package PROGRAMMERS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 프렌즈4블록 {
  static boolean flag;
  static char[][] map;
  static char[][] copyMap;
  static int M, N;
  static Set<Character> set;

  public static int solution(int m, int n, String[] board) {
    init(m, n, board);

    while (true) {
      if (!check()) {
        break;
      }
      drop();
    }

    return count();
  }

  private static int count() {
    int answer = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == '0') {
          answer++;
        }
      }
    }

    System.out.println(answer);
    return answer;
  }

  private static void drop() {
    map = new char[M][N];
    for (int i = 0; i < M; i++) {
      Arrays.fill(map[i], '0');
    }

    for (int i = 0; i < N; i++) {
      Stack<Character> s = new Stack<>();
      for (int j = 0; j < M; j++) {
        char c = copyMap[j][i];
        if (set.contains(c)) {
          s.add(c);
        }
      }

      int idx = M - 1;
      while (!s.isEmpty()) {
        map[idx--][i] = s.pop();
      }
    }
  }

  private static void init(int m, int n, String[] board) {
    M = m;
    N = n;
    map = new char[M][N];
    set = new HashSet<>();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        char c = board[i].charAt(j);
        set.add(c);
        map[i][j] = c;
      }
    }
  }

  private static boolean check() {
    flag = false;
    copy();
    for (int i = 0; i < M - 1; i++) {
      for (int j = 0; j < N - 1; j++) {
        char c = map[i][j];
        if (c == '0') {
          continue;
        }

        if (map[i+1][j] == c && map[i][j+1] == c && map[i+1][j+1] == c) {
          flag = true;
          copyMap[i][j] = '0';
          copyMap[i+1][j] = '0';
          copyMap[i][j+1] = '0';
          copyMap[i+1][j+1] = '0';
        }
      }
    }

    return flag;
  }

  private static void copy() {
    copyMap = new char[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        copyMap[i][j] = map[i][j];
      }
    }
  }

  public static void main(String[] args) {
    solution(6, 6, new String[]{"IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII"});
  }
}
