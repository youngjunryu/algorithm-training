package PROGRAMMERS;

import java.util.ArrayList;
import java.util.HashMap;

public class 순위_검색 {
  public static int[] solution(String[] info, String[] query) {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    for (String i : info) {
      String[] data = i.split(" ");
      String[] languages = {data[0], "-"};
      String[] types = {data[1], "-"};
      String[] levels = {data[2], "-"};
      String[] foods = {data[3], "-"};
      int point = Integer.parseInt(data[4]);

      for (String language : languages) {
        for (String type : types) {
          for (String level : levels) {
            for (String food : foods) {
              String[] keyData = {language, type, level, food};
              String key = String.join(" ", keyData);
              ArrayList<Integer> value = map.getOrDefault(key, new ArrayList<Integer>());
              value.add(point);
              map.put(key, value);
            }
          }
        }
      }
    }

    for (ArrayList<Integer> value : map.values()) {
      value.sort(null);
    }

    int[] answer = new int[query.length];
    int i = 0;
    for (String q : query) {
      String[] data = q.split(" and ");
      int target = Integer.parseInt(data[3].split(" ")[1]);
      data[3] = data[3].split(" ")[0];
      String key = String.join(" ", data);

      if (map.containsKey(key)) {
        ArrayList<Integer> list = map.get(key);
        int left = 0;
        int right = list.size();

        while (left < right) {
          int mid = (left + right) / 2;
          if (list.get(mid) < target) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }

        answer[i] = list.size() - right;
      }

      i++;
    }


    return answer;
  }

  public static void main(String[] args) {
    solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210",
                 "python frontend senior chicken 150", "cpp backend senior pizza 260",
                 "java backend junior chicken 80", "python backend senior chicken 50"},
             new String[]{"java and backend and junior and pizza 100",
                 "python and frontend and senior and chicken 200",
                 "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                 "- and - and - and chicken 100", "- and - and - and - 150"});
  }
}
