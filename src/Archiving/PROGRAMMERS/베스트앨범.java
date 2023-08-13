package Archiving.PROGRAMMERS;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        List<Integer> ansList = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++)
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for(int i = 0; i < list.size(); i++) {
            String key = list.get(i).getKey();
            HashMap<Integer, Integer> h = new HashMap<>();
            for(int j = 0; j < genres.length; j++) {
                if(key.equals(genres[j]))
                    h.put(j, plays[j]);
            }

            List<Map.Entry<Integer, Integer>> hList = new ArrayList<>(h.entrySet());
            Collections.sort(hList, (o1, o2) -> o1.getValue() != o2.getValue() ? o2.getValue().compareTo(o1.getValue()) : o1.getKey().compareTo(o2.getKey()));

            if(hList.size() >= 2) {
                ansList.add(hList.get(0).getKey());
                ansList.add(hList.get(1).getKey());
            }
            else
                ansList.add(hList.get(0).getKey());
        }

        answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
            answer[i] = ansList.get(i);

        return answer;
    }
}
