package PROGRAMMERS;

import java.util.*;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++)
            queue.add(0);

        for (int val : truck_weights) {
            while (sum - queue.peek() + val > weight) {
                sum -= queue.poll();
                queue.add(0);
                time++;
            }

            sum -= queue.poll();
            queue.add(val);
            sum += val;
            time++;
        }

        return time + bridge_length;
    }
}

/*

bridge_length	weight	truck_weights	                    return
2	            10	    [7,4,5,6]	                        8
100	            100	    [10]	                            101
100         	100	    [10,10,10,10,10,10,10,10,10,10]	    110

 */