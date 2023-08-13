package Archiving.PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수_2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : completion) {
            if(map.get(str) == 1) {
                map.remove(str);
            } else {
                map.put(str, map.get(str) - 1);
            }
        }
        
        for(String key : map.keySet()) {
            answer = key;
        }

        return answer;
    }
}
