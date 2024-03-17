package Programmers.lv2.예상_대진표;

class Solution {
  public int solution(int n, int a, int b) {
    int answer = 0;

    while (true) {
      a = cal(a);
      b = cal(b);
      answer += 1;
      if (a == b) break;
    }

    return answer;
  }

  private int cal(int x) {
    return x / 2 + x % 2;
  }
}
