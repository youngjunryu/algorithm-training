package PROGRAMMERS;

import java.util.PriorityQueue;

public class 더_맵게_2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }

        while(true) {
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;

            if(pq.peek() > K)
                return answer;

            if(pq.size() == 1 && pq.peek() < K)
                return -1;
        }
    }
}
