package LEETCODE;

import java.util.Stack;

public class Flood_Fill {
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, 1, -1};
  static boolean[][] visited;

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (isAlreadyColored(image, sr, sc, color)) {
      return image;
    }

    int initColor = image[sr][sc];
    Stack<Node> s = new Stack<>();
    s.push(new Node(sr, sc));
    image[sr][sc] = color;
    visited = new boolean[image.length][image[0].length];


    while (!s.isEmpty()) {
      Node cur = s.pop();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < image.length && ny < image[0].length && !visited[nx][ny]
            && image[nx][ny] == initColor) {
          visited[nx][ny] = true;
          image[nx][ny] = color;
          s.push(new Node(nx, ny));
        }
      }
    }

    return image;
  }

  private static boolean isAlreadyColored(int[][] image, int sr, int sc, int color) {
    return image[sr][sc] == color;
  }

  private static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
  }
}
