package Baekjoon._10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    SegmentTree segmentTree = new SegmentTree(N);
    segmentTree.init(arr, 1, 0, N - 1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      segmentTree.min = Integer.MAX_VALUE;

      segmentTree.query(1, 0, N - 1, a - 1, b - 1);
      System.out.println(segmentTree.min);
    }
  }

  static class SegmentTree {

    int size;
    int[] tree;
    int min;

    public SegmentTree(int n) {
      int h = (int) Math.ceil(Math.log(n) / Math.log(2));
      size = (int) Math.pow(2, h + 1);
      tree = new int[size];
      Arrays.fill(tree, Integer.MAX_VALUE);
    }

    public void init(int[] arr, int node, int start, int end) {
      if (start == end) {
        tree[node] = arr[start];
        return;
      }

      int mid = (start + end) / 2;
      init(arr, node * 2, start, mid);
      init(arr, node * 2 + 1, mid + 1, end);

      tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    public void query(int node, int start, int end, int left, int right) {
      if (left > end || right < start) {
        return;
      }

      if (left <= start && end <= right) {
        min = Math.min(min, tree[node]);
        return;
      }

      int mid = (start + end) / 2;
      query(node * 2, start, mid, left, right);
      query(node * 2 + 1, mid + 1, end, left, right);
    }
  }
}
