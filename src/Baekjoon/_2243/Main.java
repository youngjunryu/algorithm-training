package Baekjoon._2243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int MAX = 1000001;
    SegmentTree tree = new SegmentTree(MAX);
    int[] arr = new int[MAX];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());

      if (a == 1) {
        int b = Integer.parseInt(st.nextToken());
        int k = tree.query(1, 1, MAX, b);
        System.out.println(k);
        arr[k]--;
        tree.update(1, 1, MAX, k, arr[k]);
      } else {
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr[b] += c;
        tree.update(1, 1, MAX, b, arr[b]);
      }
    }
  }

  static class SegmentTree {

    int[] tree;
    int size;

    public SegmentTree(int n) {
      int h = (int) Math.ceil(Math.log(n) / Math.log(2));
      size = (int) Math.pow(2, h + 1);
      tree = new int[size];
    }

    public void update(int node, int start, int end, int idx, int val) {
      if (idx > end || idx < start) {
        return;
      }

      tree[node] = val;

      if (start != end) {
        update(node * 2, start, (start + end) / 2, idx, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
      }
    }

    public int query(int node, int start, int end, int k) {
      if (start == end) {
        return end;
      }

      int mid = (start + end) / 2;
      if (tree[node * 2] >= k) {
        return query(node * 2, start, mid, k);
      } else {
        return query(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
      }
    }
  }
}
