package Baekjoon._2357;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    SegmentTree minTree = new SegmentTree(0, N);
    SegmentTree maxTree = new SegmentTree(1, N);
    minTree.init(0, arr, 1, 1, N);
    maxTree.init(1, arr, 1, 1, N);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      minTree.min = Integer.MAX_VALUE;
      maxTree.max = 0;
      minTree.query(0, 1, 1, N, a, b);
      maxTree.query(1, 1, 1, N, a, b);

      bw.write(minTree.min + " " + maxTree.max + "\n");
    }

    bw.flush();
  }
}

class SegmentTree {

  int[] tree;
  int size;
  int min, max;

  public SegmentTree(int cmd, int n) {
    int h = (int) Math.ceil(Math.log(n) / Math.log(2));
    size = (int) Math.pow(2, h + 1);
    tree = new int[size];
    if (cmd == 0) {
      Arrays.fill(tree, Integer.MAX_VALUE);
    }
  }

  public void init(int cmd, int[] arr, int node, int start, int end) {
    if (start == end) {
      tree[node] = arr[start];
      return;
    }

    int mid = (start + end) / 2;
    init(cmd, arr, node * 2, start, mid);
    init(cmd, arr, node * 2 + 1, mid + 1, end);

    if (cmd == 0) {
      tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    } else {
      tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }
  }

  public void query(int cmd, int node, int start, int end, int left, int right) {
    if (left > end || right < start) {
      return;
    }

    if (left <= start && end <= right) {
      if (cmd == 0) {
        min = Math.min(min, tree[node]);
      } else {
        max = Math.max(max, tree[node]);
      }
      return;
    }

    int mid = (start + end) / 2;
    query(cmd, node * 2, start, mid, left, right);
    query(cmd, node * 2 + 1, mid + 1, end, left, right);
  }
}
