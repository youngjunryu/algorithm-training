package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int[] arr : routes)
            list.add(arr);
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);

        while(!list.isEmpty()) {
            int pos = list.get(0)[1];

            for(int i = 0; i < list.size(); i++) {
                if(list.get(i)[0] <= pos && list.get(i)[1] >= pos) {
                    list.remove(i);
                    i--;
                }
            }

            answer++;
        }

        return answer;
    }
}
