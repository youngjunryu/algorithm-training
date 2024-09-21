package Baekjoon._1275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    SegmentTree tree = new SegmentTree(N + 1);
    tree.init(arr, 1, 1, N);

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (x > y) {
        int temp = y;
        y = x;
        x = temp;
      }

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      long k = tree.query(1, 1, N, x, y);
      System.out.println(k);

      tree.update(1, 1, N, a, b);
    }
  }

  static class SegmentTree {

    int size;
    long[] tree;

    public SegmentTree(int n) {
      int h = (int) Math.ceil(Math.log(n) / Math.log(2));
      this.size = (int) Math.pow(2, h + 1);
      tree = new long[size];
    }

    public long init(int[] arr, int node, int start, int end) {
      if (start == end) {
        return tree[node] = arr[start];
      }

      int mid = (start + end) / 2;
      return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
    }

    public void update(int node, int start, int end, int idx, int val) {
      if (idx > end || idx < start) {
        return;
      }

      tree[node] = val;

      int mid = (start + end) / 2;
      if (start != end) {
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
      }
    }

    public long query(int node, int start, int end, int left, int right) {
      if (left > end || right < start) {
        return 0;
      }

      if (left <= start && end <= right) {
        return tree[node];
      }

      int mid = (start + end) / 2;
      return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left,
          right);
    }
  }
}
