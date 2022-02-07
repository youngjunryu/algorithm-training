import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            } else {
                int temp = map.get(participant[i]);
                map.put(participant[i], temp + 1);
            }
        }

        for(int i = 0; i < completion.length; i++) {
            if(map.get(completion[i]) != 1) {
                int temp = map.get(completion[i]);
                map.put(completion[i], temp - 1);
            } else {
                map.remove(completion[i]);
            }
        }

        Iterator<String> it = map.keySet().iterator();
        answer = it.next();

        return answer;
    }
}
