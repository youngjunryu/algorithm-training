package Archiving.PROGRAMMERS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_2 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0;
        int end = 0;
        int pos = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (cnt < jobs.length) {
            while (pos < jobs.length && end >= jobs[pos][0]) {
                pq.add(jobs[pos++]);
            }

            if (pq.isEmpty()) {
                end = jobs[pos][0];
            } else {
                int[] temp = pq.poll();
                answer += end - temp[0] + temp[1];
                end += temp[1];
                cnt++;
            }
        }

        return (int)Math.floor(answer / jobs.length);
    }

    public static void main(String[] args) {
        solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
    }
}

/*

[[0, 3], [1, 9], [2, 6]]	9

 */