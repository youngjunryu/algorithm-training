package LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum {
  static List<List<Integer>> answer;

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    answer = new ArrayList<>();
    Arrays.sort(candidates);
    backtracking(0, target, candidates, new LinkedList<>());

    return answer;
  }

  private static void backtracking(int i, int target, int[] candidates, LinkedList<Integer> path) {
    if (target == 0) {
      answer.add((List<Integer>) path.clone());
      return;
    }

    if (i == candidates.length || target < candidates[i]) {
      return;
    }

    path.add(candidates[i]);
    backtracking(i, target - candidates[i], candidates, path);
    path.removeLast();

    backtracking(i + 1, target, candidates, path);
  }
}
