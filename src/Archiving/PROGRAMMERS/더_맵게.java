package Archiving.PROGRAMMERS;

import java.util.*;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < scoville.length; i++)
            pq.offer(scoville[i]);

        while(pq.peek() < K) {
            if(pq.size() <= 1)  {
                answer = -1;
                break;
            }

            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b * 2);
            answer++;
        }

        return answer;
    }
}