package Archiving.PROGRAMMERS;

public class H_index {
    public int solution(int[] citations) {

        int left = 0;
        int right = citations[citations.length - 1];
        int mid = 0;
        int answer = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            int h = countH(mid, citations);
            if(h >= mid) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        return answer;
    }

    private int countH(int mid, int[] citations) {
        int cnt = 0;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= mid)
                cnt++;
        }

        return cnt;
    }
}
