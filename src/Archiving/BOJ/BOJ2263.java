package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2263 {
  static int[] inOrder, postOrder;
  static int[] preOrder;
  static int idx = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    inOrder = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
    s = br.readLine().split(" ");
    postOrder = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

    preOrder = new int[N];
    order(0, N-1, 0, N-1);

    for (int i = 0; i < N; i++) {
      System.out.print(preOrder[i] + " ");
    }
  }

  private static void order(int il, int ir, int pl, int pr) {
    if (il > ir || pl > pr) {
      return;
    }

    int root = postOrder[pr];

    int k = -1;
    for (int i = il; i <= ir; i++) {
      if (inOrder[i] == root) {
        k = i;
        break;
      }
    }

    int cnt = k - il;
    preOrder[idx++] = root;
    order(il, k - 1, pl, pl + cnt - 1);
    order(k + 1, ir, pl + cnt, pr - 1);
  }
}