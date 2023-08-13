package Archiving.PROGRAMMERS;

import java.util.*;

public class 기능개발_2 {
    public Object[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            q.add((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }

        while(!q.isEmpty()) {
            int day = q.poll();
            int cnt = 1;

            while(!q.isEmpty() && day >= q.peek()) {
                cnt++;
                q.poll();
            }

            answer.add(cnt);
        }

        return answer.stream().toArray(Integer[] :: new);
    }
}
