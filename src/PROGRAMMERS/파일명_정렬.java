package PROGRAMMERS;

import java.util.Locale;
import java.util.PriorityQueue;

public class 파일명_정렬 {
  static PriorityQueue<Node> pq;

  public static String[] solution(String[] files) {
    processing(files);
    return getAnswer(files.length);
  }

  private static String[] getAnswer(int len) {
    String[] answer = new String[len];
    int idx = 0;
    while (!pq.isEmpty()) {
      answer[idx++] = pq.poll().file;
    }
    return answer;
  }

  private static void processing(String[] files) {
    pq = new PriorityQueue<>();
    for (int i = 0; i < files.length; i++) {
      pq.add(new Node(files[i], i));
    }
  }

  static class Node implements Comparable<Node> {
    String head;
    int number;
    int order;
    String file;

    public Node(String file, int order) {
      this.file = file;
      this.order = order;
      int idx = 0;
      StringBuilder sb = new StringBuilder();
      while (true) {
        char c = file.charAt(idx);
        if (c - '0' >= 0 && c - '0' <= 9) {
          break;
        }

        sb.append(c);
        idx++;
      }
      this.head = sb.toString().toLowerCase(Locale.ROOT);

      sb = new StringBuilder();
      while (true) {
        if (idx >= file.length()) {
          break;
        }

        char c = file.charAt(idx);
        if (c - '0' >= 0 && c - '0' <= 9) {
          sb.append(c);
          idx++;
        } else {
          break;
        }
      }
      this.number = Integer.parseInt(sb.toString());
    }

    @Override
    public int compareTo(Node o) {
      if (!this.head.equals(o.head)) {
        return this.head.compareTo(o.head);
      } else {
        if (this.number != o.number) {
          return this.number - o.number;
        } else {
          return this.order - o.order;
        }
      }
    }
  }
}
