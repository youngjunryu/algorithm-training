package Archiving.PROGRAMMERS;

import java.util.Map;

public class 숫자_문자열과_영단어 {
  public static int solution(String s) {
    Map<String, String> map = Map.of("one", "1",
                                 "two", "2",
                                 "three", "3",
                                 "four", "4",
                                 "five", "5",
                                 "six", "6",
                                 "seven", "7",
                                 "eight", "8",
                                 "nine", "9",
                                 "zero", "0");
    StringBuilder result = new StringBuilder();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c - '0' >= 0 && c - '0' <= 9) {
        result.append(c);
      } else {
        sb.append(c);
        if (map.containsKey(sb.toString())) {
          result.append(map.get(sb.toString()));
          sb = new StringBuilder();
        }
      }
    }

    return Integer.parseInt(result.toString());
  }

  public static void main(String[] args) {
    solution("123");
  }
}
