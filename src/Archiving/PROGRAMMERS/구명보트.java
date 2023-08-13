package Archiving.PROGRAMMERS;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {

        int left = 0, right = people.length - 1;
        int answer = 0;
        Arrays.sort(people);

        while(left < right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }

        if(left == right)
            answer++;

        return answer;
    }
}

/*

[50, 50, 70, 80]	3
[50, 70, 80]	3
[10, 20, 30, 30, 40, 50]

 */