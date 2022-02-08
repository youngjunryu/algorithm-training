import java.util.*;

public class 입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long start = 1;
        long end = n * (long)times[times.length - 1];
        long mid = -1;
        long value = 0;

        while(start <= end) {
            value = 0;
            mid = (start + end) / 2;

            for(int i = 0; i < times.length; i++)
                value += mid / times[i];

            if(value < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}

/*

6
7 10
28

 */