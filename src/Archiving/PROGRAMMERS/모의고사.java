package Archiving.PROGRAMMERS;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] result = {0, 0, 0};

        for(int i = 0; i < answers.length; i++) {
            if(a[i % 5] == answers[i]) result[0]++;
            if(b[i % 8] == answers[i]) result[1]++;
            if(c[i % 10] == answers[i]) result[2]++;
        }

        int max = Math.max(Math.max(result[0], result[1]), result[2]);
        for(int i = 0; i < 3; i++) {
            if(max == result[i])
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for(int i =0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
