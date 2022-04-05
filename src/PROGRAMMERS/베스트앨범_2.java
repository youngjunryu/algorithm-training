package PROGRAMMERS;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범_2 {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        List<Integer> ansList = new ArrayList<>();

        HashMap<String, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entries = totalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());

        for (int i = 0; i < entries.size(); i++) {
            String key = entries.get(i).getKey();
            System.out.println(key);
            HashMap<Integer, Integer> keyMap = new HashMap<>();

            for (int j = 0; j < genres.length; j++) {
                if (key.equals(genres[j])) {
                    keyMap.put(j, plays[j]);
                }
            }

            List<Map.Entry<Integer, Integer>> mapForGenreList = keyMap.entrySet().stream()
                    .sorted((o1, o2) -> o1.getValue() != o2.getValue() ? o2.getValue().compareTo(o1.getValue()) : o1.getKey().compareTo(o2.getKey()))
                    .collect(Collectors.toList());

            if (mapForGenreList.size() >= 2) {
                ansList.add(mapForGenreList.get(0).getKey());
                ansList.add(mapForGenreList.get(1).getKey());
            } else {
                ansList.add(mapForGenreList.get(0).getKey());
            }
        }

        answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
            answer[i] = ansList.get(i);

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}

/*

["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

 */