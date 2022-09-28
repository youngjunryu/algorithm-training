package LEETCODE;

import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int[] point : points) {
      pq.add(new Node(point[0], point[1]));
    }
    
    int[][] answer = new int[k][2];
    for (int i = 0; i < k; i++) {
      Node n = pq.poll();
      answer[i][0] = n.x;
      answer[i][1] = n.y;
    }

    return answer;
  }
  
  static class Node implements Comparable<Node> {
    int x;
    int y;
    int distance;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = x * x + y * y;
    }

    @Override
    public int compareTo(Node o) {
      return this.distance - o.distance;
    }
  }
}
