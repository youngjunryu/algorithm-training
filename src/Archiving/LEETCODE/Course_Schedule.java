package Archiving.LEETCODE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {
  static List<Integer>[] course;
  static int[] inCnt;

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    course = new LinkedList[numCourses];
    inCnt = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      course[i] = new LinkedList<>();
    }

    for (int[] p : prerequisites) {
      int start = p[0];
      int end = p[1];
      course[start].add(end);
      inCnt[end]++;
    }

    return checkCourse(numCourses);
  }

  private static boolean checkCourse(int numCourses) {
    HashSet<Integer> finishSubjects = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (inCnt[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int subject = q.poll();

      for (int next : course[subject]) {
        inCnt[next]--;
        if (inCnt[next] == 0) {
          q.add(next);
        }
      }

      finishSubjects.add(subject);
    }

    if (finishSubjects.size() == numCourses) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        canFinish(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7 ,0}, {0, 5}}));
  }
}

/*

1 0
2 6
1 7
6 4
7 0
0 5

 */
