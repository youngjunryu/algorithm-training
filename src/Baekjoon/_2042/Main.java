package Baekjoon._2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    long[] arr = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    // 세그먼트트리 세팅
    SegmentTree segmentTree = new SegmentTree(N);
    segmentTree.init(arr, 1, 1, N);

    // 세그먼트트리 Operation
    for (int i = 1; i <= M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if (a == 1) {
        segmentTree.update(1, 1, N, b, c - arr[b]);
        arr[b] = c;
      } else if (a == 2) {
        long sum = segmentTree.sum(1, 1, N, b, (int) c);
        System.out.println(sum);
      }
    }
  }

  static class SegmentTree {

    long[] tree;
    int size;

    public SegmentTree(int n) {
      int h = (int) Math.ceil(Math.log(n) / Math.log(2));
      size = (int) Math.pow(2, h + 1);
      tree = new long[size];
    }

    public long init(long[] arr, int node, int start, int end) {
      if (start == end) {
        return tree[node] = arr[start];
      }

      return tree[node] =
          init(arr, node * 2, start, (start + end) / 2) + init(arr, node * 2 + 1,
              (start + end) / 2 + 1, end);
    }

    public void update(int node, int start, int end, int idx, long diff) {
      if (idx > end || idx < start) {
        return;
      }

      tree[node] += diff;

      if (start != end) {
        update(node * 2, start, (start + end) / 2, idx, diff);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
      }
    }

    public long sum(int node, int start, int end, int left, int right) {
      if (left > end || right < start) {
        return 0;
      }

      if (left <= start && end <= right) {
        return tree[node];
      }

      return sum(node * 2, start, (start + end) / 2, left, right) + sum(node * 2 + 1,
          (start + end) / 2 + 1, end, left, right);
    }
  }
}
