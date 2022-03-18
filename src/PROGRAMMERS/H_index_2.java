package PROGRAMMERS;

import java.util.Arrays;
import java.util.Collections;

public class H_index_2 {
    public int solution(int[] citations) {
        int answer = 0;

        int start = 0;
        int end = citations[citations.length-1];

        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = countH(citations, mid);

            if(cnt >= mid) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    public int countH(int[] citations, int mid) {
        int cnt = 0;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= mid)
                cnt++;
        }

        return cnt;
    }
}

/*
0 1 3 5 6
 */