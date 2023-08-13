package Archiving.PROGRAMMERS;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐_2 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> highQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> lowQueue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] arr = operation.split(" ");
            int num = Integer.valueOf(arr[1]);
            if (arr[0].equals("I")) {
                highQueue.add(num);
                lowQueue.add(num);
            } else {
                if (highQueue.size() == 0) {
                    continue;
                }
                if (num == -1) {
                    int value = lowQueue.poll();
                    highQueue.remove(value);
                } else {
                    int value = highQueue.poll();
                    lowQueue.remove(value);
                }
            }
        }

        return highQueue.size() != 0 ? new int[]{highQueue.peek(), lowQueue.peek()} : answer;
    }
}

/*

["I 16","D 1"]	[0,0]
["I 7","I 5","I -5","D -1"]	[7,5]

 */
