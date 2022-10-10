package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
  static List<List<Integer>> answer;
  static boolean[] visited;

  public static List<List<Integer>> permute(int[] nums) {
    answer = new LinkedList<>();
    visited = new boolean[nums.length];

    backtracking(nums, new LinkedList<>());

    return answer;
  }

  private static void backtracking(int[] nums, LinkedList<Integer> path) {
    if (path.size() == nums.length) {
      answer.add((List<Integer>)path.clone());
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        path.add(nums[i]);
        visited[i] = true;
        backtracking(nums, path);
        path.removeLast();
        visited[i] = false;
      }
    }
  }
}
