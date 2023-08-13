package Archiving.PROGRAMMERS;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[31];

        for(int i : lost)
            arr[i]--;
        for(int i : reserve)
            arr[i]++;

        for(int i = 1; i <= n; i++) {
            if(arr[i] == -1) {
                if(arr[i-1] == 1) arr[i-1] = arr[i] = 0;
                else if(arr[i+1] == 1) arr[i+1] = arr[i] = 0;
            }
            if(arr[i] >= 0) answer++;
        }

        return answer;
    }
}