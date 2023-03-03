package PROGRAMMERS;

public class 일일공_옮기기 {
  public static String[] solution(String[] s) {
    String[] answer = new String[s.length];

    for (int i = 0; i < s.length; i++) {
      answer[i] = execute(s[i]);
      System.out.println(answer[i]);
    }

    return answer;
  }

  private static String execute(String s) {
    StringBuilder sb = new StringBuilder();

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i));
      if (sb.length() >= 3) {
        if (sb.substring(sb.length() - 3, sb.length()).equals("110")) {
          count++;
          sb.delete(sb.length() - 3, sb.length());
        }
      }
    }

    StringBuilder answer = new StringBuilder();
    int lastIdx = findLastZero(sb);
    if (lastIdx == -1) {
      while (count-- > 0) {
        answer.append("110");
      }
      answer.append(sb);
    } else {
      for (int i = 0; i < sb.length(); i++) {
        if (i == lastIdx) {
          answer.append(sb.charAt(i));
          while (count-- > 0) {
            answer.append("110");
          }
        } else {
          answer.append(sb.charAt(i));
        }
      }
    }

    return answer.toString();
  }

  private static int findLastZero(StringBuilder sb) {
    for (int i = sb.length() - 1; i >= 0; i--) {
      if (sb.charAt(i) == '0') {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    solution(new String[]{"1110", "100111100", "0111111010", "1110011100"});
  }
}
