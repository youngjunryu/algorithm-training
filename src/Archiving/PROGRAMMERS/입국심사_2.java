package Archiving.PROGRAMMERS;

public class 입국심사_2 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long start = 1;
        long end = (long)n * times[times.length - 1];

        while(start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for(long i : times) {
                sum += mid / i;
            }

            if(sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
