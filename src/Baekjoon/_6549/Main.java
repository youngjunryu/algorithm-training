package Baekjoon._6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static long result;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      if (N == 0) {
        return;
      }

      long[] arr = new long[N + 1];

      for (int i = 1; i <= N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      SegmentTree segmentTree = new SegmentTree(arr, N);
      segmentTree.init(1, 1, N);
      result = 0;

      calculate(segmentTree, 1, N);
      System.out.println(result);
    }
  }

  public static void calculate(SegmentTree segmentTree, int left, int right) {
    if (left > right) {
      return;
    }

    segmentTree.min = left;
    segmentTree.query(1, 1, N, left, right);
    int idx = segmentTree.min;
    result = Math.max(segmentTree.arr[idx] * (right - left + 1), result);

    calculate(segmentTree, left, idx - 1);
    calculate(segmentTree, idx + 1, right);
  }

  static class SegmentTree {

    long[] arr;
    int[] tree;
    int size;
    int min;

    public SegmentTree(long[] arr, int n) {
      int h = (int) Math.ceil(Math.log(n) / Math.log(2));
      this.size = (int) Math.pow(2, h + 1);
      tree = new int[size];
      Arrays.fill(tree, Integer.MAX_VALUE);
      this.arr = arr;
    }

    public void init(int node, int start, int end) {
      if (start == end) {
        tree[node] = start;
        return;
      }

      int mid = (start + end) / 2;
      init(node * 2, start, mid);
      init(node * 2 + 1, mid + 1, end);

      if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
        tree[node] = tree[node * 2];
      } else {
        tree[node] = tree[node * 2 + 1];
      }
    }

    public void query(int node, int start, int end, int left, int right) {
      if (left > end || right < start) {
        return;
      }

      if (left <= start && end <= right) {
        if (arr[min] > arr[tree[node]]) {
          min = tree[node];
        }
        return;
      }

      int mid = (start + end) / 2;
      query(node * 2, start, mid, left, right);
      query(node * 2 + 1, mid + 1, end, left, right);
    }
  }
}

