package Archiving.PROGRAMMERS;

import java.util.Arrays;

public class 구명보트_2 {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while(left < right) {

            if(people[left] + people[right] > limit) {
                answer++;
                right--;
            } else {
                answer++;
                right--;
                left++;
            }

            if(left == right)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{70, 50, 80}, 100);
    }
}
