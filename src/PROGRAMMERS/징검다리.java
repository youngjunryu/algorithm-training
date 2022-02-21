package PROGRAMMERS;

import java.util.*;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for(int i : rocks)
            list.add(i);
        Collections.sort(list);
        list.add(distance);

        int left = 1;
        int right = distance;

        while(left <= right) {
            int mid = (left + right) / 2;
            int prev = 0;
            int cnt = 0;

            for(int i = 0; i <= rocks.length; i++) {
                int k = list.get(i) - prev;
                if(k >= mid) {
                    prev = list.get(i);
                } else {
                    cnt++;
                }
            }

            if(cnt <= n) {
                answer = mid > answer ? mid : answer;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        return answer;
    }
}
