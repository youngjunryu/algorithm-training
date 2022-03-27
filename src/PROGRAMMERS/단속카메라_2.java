package PROGRAMMERS;

import java.util.Arrays;

public class 단속카메라_2 {
    public int solution(int[][] routes) {
        int answer = 0;
        int idx = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        while (true) {

            int cur = routes[idx][1];
            answer++;
            idx++;

            while (idx < routes.length && cur >= routes[idx][0]) {
                idx++;
            }

            if (idx >= routes.length) break;
        }

        return answer;
    }
}
