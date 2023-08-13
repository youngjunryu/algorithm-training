package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Collections;

public class 징검다리_2 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = distance;

        for (int rock : rocks) {
            list.add(rock);
        }

        Collections.sort(list);
        list.add(distance);

        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = 0;
            int cnt = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) - prev >= mid) {
                    prev = list.get(i);
                } else {
                    cnt++;
                }
            }

            if (cnt <= n) {
                answer = Math.max(mid, answer);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}

/*

25	[2, 14, 11, 21, 17]	2	4

0 2 11 14 17 21 25

*/
