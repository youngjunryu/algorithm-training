package Archiving.PROGRAMMERS;

import java.util.HashSet;

public class 롤케이크_자르기 {
  public static int solution(int[] topping) {
    int answer = 0;

    HashSet<Integer> leftSet = new HashSet<>();
    HashSet<Integer> rightSet = new HashSet<>();
    for (int t : topping) {
      rightSet.add(t);
    }

    int[] toppingIdxArr = new int[10001];
    for (int t : topping) {
      toppingIdxArr[t]++;
    }

    for (int t : topping) {
      leftSet.add(t);
      toppingIdxArr[t]--;
      if (toppingIdxArr[t] <= 0) {
        rightSet.remove(t);
      }

      if (leftSet.size() == rightSet.size()) {
        answer++;
      }
    }

    return answer;
  }
}
