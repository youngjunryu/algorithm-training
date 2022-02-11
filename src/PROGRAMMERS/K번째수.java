package PROGRAMMERS;

import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ansList = new ArrayList<>();

        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;

            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            ansList.add(temp[k]);
        }

        int[] answer = new int[ansList.size()];
        int cur = 0;
        for(Integer i : ansList)
            answer[cur++] = i;

        return answer;
    }
}