package PROGRAMMERS;

import java.util.*;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int result = 0;
        int cnt = 0;
        int pos = 0;
        int end = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        while(cnt < jobs.length) {
            while(pos < jobs.length && jobs[pos][0] <= end) {
                pq.add(jobs[pos++]);
            }

            if(pq.isEmpty())
                end = jobs[pos][0];
            else {
                int[] temp = pq.poll();
                result += end - temp[0] + temp[1];
                end += temp[1];
                cnt++;
            }
        }

        return (int)Math.floor(result / jobs.length);
    }
}

