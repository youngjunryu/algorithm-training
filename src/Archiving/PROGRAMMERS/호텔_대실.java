package Archiving.PROGRAMMERS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔_대실 {
  public static int solution(String[][] book_time) {
    Arrays.sort(book_time, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));

    PriorityQueue<Node> pq = new PriorityQueue<>();
    int endTime = calculateTime(book_time[0][1]) + 10;
    pq.add(new Node(endTime));
    int count = 1;

    for (int i = 1; i < book_time.length; i++) {
      int startTime = calculateTime(book_time[i][0]);
      if (startTime < pq.peek().endTime) {
        count++;
        pq.add(new Node(calculateTime(book_time[i][1]) + 10));
      } else {
        pq.poll();
        pq.add(new Node(calculateTime(book_time[i][1]) + 10));
      }
    }

    return count;
  }

  public static int calculateTime(String s) {
    String[] arr = s.split(":");
    return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
  }

  static class Node implements Comparable<Node> {
    int endTime;

    public Node(int endTime) {
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Node o) {
      return this.endTime - o.endTime;
    }
  }

  public static void main(String[] args) {
    solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
        {"18:20", "21:20"}});
  }
}
