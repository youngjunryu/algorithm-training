package PROGRAMMERS;

import java.util.Arrays;

public class 타겟_넘버_2 {

    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        int[] arr = new int[numbers.length];
        dfs(numbers, 0, arr, target);

        return answer;
    }

    public static void dfs(int[] numbers, int depth, int[] arr, int target) {

        if(depth == numbers.length) {
            if(target == Arrays.stream(arr).sum())
                answer++;
            return;
        }

        arr[depth] = numbers[depth];
        dfs(numbers, depth + 1, arr, target);
        arr[depth] = -1 * numbers[depth];
        dfs(numbers, depth + 1, arr, target);
    }
}