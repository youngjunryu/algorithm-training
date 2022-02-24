package PROGRAMMERS;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for(String str : operations) {
            StringTokenizer st = new StringTokenizer(str);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(op == 'I') {
                maxPq.add(num);
                minPq.add(num);
            } else {
                if(maxPq.size() == 0)
                    continue;
                if(num == 1) {
                    int value = maxPq.poll();
                    minPq.remove(value);
                } else {
                    int value = minPq.poll();
                    maxPq.remove(value);
                }
            }
        }

        if(maxPq.size() == 0) return answer;
        else {
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
            return answer;
        }
    }
}
