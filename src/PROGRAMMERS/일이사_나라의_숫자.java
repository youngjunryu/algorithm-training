package PROGRAMMERS;

public class 일이사_나라의_숫자 {
  static final String[] DIGIT = {"4", "1", "2"};

  public static String solution(int n) {
    StringBuilder sb = new StringBuilder();

    while (n != 0 ) {
      int index = n % 3;

      n /= 3;

      if (index == 0) {
        n--;
      }

      sb.append(DIGIT[index]);
    }

    sb.reverse();

    return sb.toString();
  }
}
