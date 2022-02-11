package PROGRAMMERS;

import java.util.*;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++)
            queue.offer((int)(Math.ceil((100 - progresses[i]) / (double)speeds[i])));

        List<Integer> answerList = new LinkedList<>();
        while(!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }

            answerList.add(cnt);
        }

        int[] answer = new int[answerList.size()];
        int cur = 0;
        for(Integer i : answerList)
            answer[cur++] = i;

        return answer;
    }
}
