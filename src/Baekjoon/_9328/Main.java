package Baekjoon._9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int h, w;
  static char[][] map;
  static HashSet<Character> store;
  static int answer;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      answer = 0;
      store = new HashSet<>();
      map = new char[h][w];
      for (int i = 0; i < h; i++) {
        String s = br.readLine();
        for (int j = 0; j < w; j++) {
          map[i][j] = s.charAt(j);
        }
      }

      String s = br.readLine();
      if (!s.equals("0")) {
        for (int i = 0; i < s.length(); i++) {
          store.add(s.charAt(i));
        }
      }

      go();
      System.out.println(answer);
    }
  }

  private static void go() {
    Queue<Node> q = new LinkedList<>();
    boolean[][] visited = new boolean[h][w];
    List<Node>[] doors = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
      doors[i] = new ArrayList<>();
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
          char c = map[i][j];
          if (c == '*') {
            continue;
          }

          if ('a' <= c && c <= 'z') {
            store.add(c);
            visited[i][j] = true;
            q.add(new Node(i, j));
          } else if (c == '$') {
            q.add(new Node(i, j));
            visited[i][j] = true;
            answer++;
          } else if (c == '.') {
            q.add(new Node(i, j));
            visited[i][j] = true;
          } else if ('A' <= c && c <= 'Z') {
            if (store.contains(Character.toLowerCase(c))) {
              visited[i][j] = true;
              q.add(new Node(i, j));
            } else {
              int doorIdx = c - 'A';
              doors[doorIdx].add(new Node(i, j));
            }
          }
        }
      }
    }

    while (!q.isEmpty()) {
      Node now = q.poll();
      int x = now.x;
      int y = now.y;

      for (int d = 0; d < 4; d++) {
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == '*') {
          continue;
        }

        char c = map[nx][ny];

        if ('a' <= c && c <= 'z') {
          q.add(new Node(nx, ny));
          visited[nx][ny] = true;
          store.add(c);

          int keyIdx = c - 'a';
          for (Node n : doors[keyIdx]) {
            visited[n.x][n.y] = true;
            q.add(new Node(n.x, n.y));
          }
          doors[keyIdx].clear();
        } else if (c == '$') {
          q.add(new Node(nx, ny));
          visited[nx][ny] = true;
          answer++;
        } else if (c == '.') {
          q.add(new Node(nx, ny));
          visited[nx][ny] = true;
        } else if ('A' <= c && c <= 'Z') {
          if (store.contains(Character.toLowerCase(c))) {
            q.add(new Node(nx, ny));
            visited[nx][ny] = true;
          } else {
            int doorIdx = c - 'A';
            doors[doorIdx].add(new Node(nx, ny));
          }
        }
      }
    }
  }


  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
