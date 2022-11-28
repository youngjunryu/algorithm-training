package PROGRAMMERS;

import java.util.ArrayList;

public class 방금그곡 {
  public static String solution(String m, String[] musicinfos) {
    String answer = "(None)";

    StringBuilder sb = new StringBuilder();
    getNoteList(m).forEach(sb::append);
    m = sb.toString();

    int max = Integer.MIN_VALUE;
    for (String music : musicinfos) {
      String[] arr = music.split(",");
      String start = arr[0];
      String end = arr[1];
      String name = arr[2];
      String info = arr[3];

      int time =
          (Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5))) - (
              Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5)));

      ArrayList<String> note = getNoteList(info);
      sb = new StringBuilder();
      for (int i = 0; i < time; i++) {
        sb.append(note.get(i % note.size()));
      }

      if (sb.toString().contains(m) && time > max) {
        answer = name;
        max = time;
      }
    }

    return answer;
  }

  private static ArrayList<String> getNoteList(String info) {
    ArrayList<String> note = new ArrayList<>();
    int idx = 0;
    while (idx < info.length()) {
      if (idx + 1 < info.length() && info.charAt(idx + 1) == '#') {
        note.add(String.valueOf(Character.toLowerCase(info.charAt(idx))));
        idx += 2;
      } else {
        note.add(String.valueOf(info.charAt(idx++)));
      }
    }

    return note;
  }

  public static void main(String[] args) {
    System.out.println(solution("DF", new String[]{"6:20,6:50,TEST,DDF"}));
  }
}
