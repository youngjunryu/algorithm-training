package Archiving.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭_2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int idx = 0;

        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        while(!q.isEmpty()) {
            answer++;
            sum -= q.peek();
            q.poll();
            if(idx < truck_weights.length) {
                if(sum + truck_weights[idx] <= weight) {
                    sum += truck_weights[idx];
                    q.add(truck_weights[idx++]);
                } else {
                    q.add(0);
                }
            }
        }

        return answer;
    }
}


/*

0 0
0 7

 */