package PROGRAMMERS;

import java.util.HashMap;

public class 오픈채팅방 {
  public static String[] solution(String[] record) {
    HashMap<String, String> map = new HashMap<>();
    int count = 0;
    for (String r : record) {
      String[] arr = r.split(" ");
      if (arr[0].equals("Leave")) {
        continue;
      } else if (arr[0].equals("Change")) {
        count++;
      }
      map.put(arr[1], arr[2]);
    }

    String[] answer = new String[record.length - count];
    int idx = 0;
    for (String r : record) {
      String[] arr = r.split(" ");
      if (arr[0].equals("Enter")) {
        answer[idx++] = map.get(arr[1]) + "님이 들어왔습니다.";
      } else if (arr[0].equals("Leave")) {
        answer[idx++] = map.get(arr[1]) + "님이 나갔습니다.";
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
        "Enter uid1234 Prodo","Change uid4567 Ryan"});
  }
}
