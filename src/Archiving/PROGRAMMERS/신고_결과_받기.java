package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고_결과_받기 {
  static int n;
  static HashSet<String> reportRecordMap;
  static HashMap<String, Integer> reportIdMap;
  static HashMap<String, ArrayList<String>> reportUserMap;
  static HashMap<String, Integer> idMap;

  public static int[] solution(String[] id_list, String[] report, int k) {
    n = id_list.length;
    reportRecordMap = new HashSet<>();
    reportUserMap = new HashMap<>();
    initIdMap(id_list);

    for (String r : report) {
      if (reportRecordMap.contains(r)) {
        continue;
      }

      String[] s = r.split(" ");

      reportRecordMap.add(r);
      reportIdMap.put(s[1], reportIdMap.getOrDefault(s[1], 0) + 1);

      if (reportUserMap.get(s[1]) == null) {
        reportUserMap.put(s[1], new ArrayList<>());
      }
      ArrayList<String> list = reportUserMap.get(s[1]);
      list.add(s[0]);
    }

    /*Iterator<String> iter = reportIdMap.keySet().iterator();
    while (iter.hasNext()) {
      String key = iter.next();
      Integer value = reportIdMap.get(key);
      System.out.println(key + " : " + value);
    }*/

    return getAnswer(k);
  }

  private static int[] getAnswer(int k) {
    int[] answer = new int[n];
    for (String id : reportIdMap.keySet()) {
      int cnt = reportIdMap.get(id);
      if (cnt >= k) {
        ArrayList<String> list = reportUserMap.get(id);
        for (String a : list) {
          answer[idMap.get(a)]++;
        }
      }
    }

    System.out.println(Arrays.toString(answer));

    return answer;
  }

  private static void initIdMap(String[] id_list) {
    reportIdMap = new HashMap<>();
    idMap = new HashMap<>();
    int value = 0;
    for (int i = 0; i < id_list.length; i++) {
      String id = id_list[i];
      reportIdMap.put(id, value);
      idMap.put(id, i);
    }
  }

  public static void main(String[] args) {
    solution(new String[]{"con", "ryan"},
             new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
             3);
  }
}

/*

["muzi", "frodo", "apeach", "neo"]
["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
2
[2,1,1,0]

["con", "ryan"]
["ryan con", "ryan con", "ryan con", "ryan con"]
3
[0,0]

 */