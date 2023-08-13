package Archiving.PROGRAMMERS;

public class 신규_아이디_추천 {
  public static String solution(String new_id) {
    String id = new_id.toLowerCase();
    id = id.replaceAll("[^a-z0-9._-]", "");
    id = id.replaceAll("[.]{2,}", ".");

    if (id.charAt(0) == '.') {
      id = id.replaceFirst("[.]", "");
    }

    if (!id.isBlank() && id.charAt(id.length() - 1) == '.') {
      id = id.substring(0, id.length() - 1);
    }

    if (id.isBlank()) {
      id = "a";
    }

    if (id.length() >= 16) {
      id = id.substring(0, 15);

      if (id.charAt(id.length() - 1) == '.') {
        id = id.substring(0, id.length() - 1);
      }
    }

    if (id.length() <= 2) {
      char lastChar = id.charAt(id.length() - 1);
      while (id.length() < 3) {
        id = id + lastChar;
      }
    }

    return id;
  }

  public static void main(String[] args) {
    solution("abcdefghijklmn.p");
  }
}
