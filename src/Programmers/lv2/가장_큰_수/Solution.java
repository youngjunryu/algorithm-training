package Programmers.lv2.가장_큰_수;

import java.util.Arrays;

class Solution {
  public String solution(int[] numbers) {
    String answer = "";
    int n = numbers.length;

    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
      str[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(str, (o1, o2) -> {
      int a = Integer.parseInt(o1 + o2);
      int b = Integer.parseInt(o2 + o1);

      if (a > b) return -1;
      else if (a < b) return 1;
      else return 0;
    });

    if(str[0].equals("0")) return "0";

    StringBuilder sb = new StringBuilder();
    for (String s : str) {
      sb.append(s);
    }

    return sb.toString();
  }
}
