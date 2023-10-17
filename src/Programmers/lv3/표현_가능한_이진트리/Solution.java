package Programmers.lv3.표현_가능한_이진트리;

public class Solution {
  int result;

  public int[] solution(long[] numbers) {
    int[] answer = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      String binaryNum = Long.toBinaryString(numbers[i]);

      int len = 0;
      int h = 1;

      while (len < binaryNum.length()) {
        len = (int) Math.pow(2, h++) - 1;
      }

      boolean[] isOne = new boolean[len];

      int notDummyIdx = isOne.length - binaryNum.length();
      for (int j = 0; j < binaryNum.length(); j++) {
        isOne[notDummyIdx++] = binaryNum.charAt(j) == '1';
      }

      result = 1;
      dfs(0, isOne.length - 1, false, isOne);
      answer[i] = result;
    }

    return answer;
  }

  void dfs(int start, int end, boolean isParentZero, boolean[] isOne) {
    if (result == 0) return;

    int mid = (start + end) / 2;

    if (isParentZero && isOne[mid]) {
      result = 0;
      return;
    }

    if (start != end) {
      dfs(start, mid - 1, !isOne[mid], isOne);
      dfs(mid + 1, end, !isOne[mid], isOne);
    }
  }
}
