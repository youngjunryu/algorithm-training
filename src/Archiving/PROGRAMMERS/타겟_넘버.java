package Archiving.PROGRAMMERS;

public class 타겟_넘버 {
    static int answer;

    private static void dfs(int depth, int[] numbers, int target, int[] arr) {
        if(depth == numbers.length) {
            int sum = 0;
            for(Integer i : arr)
                sum += i;
            if(sum == target)
                answer++;
            return;
        }

        arr[depth] = numbers[depth];
        dfs(depth + 1, numbers, target, arr);
        arr[depth] = -1 * numbers[depth];
        dfs(depth + 1, numbers, target, arr);
    }


    public static int solution(int[] numbers, int target) {
        answer = 0;
        int[] arr = new int[numbers.length];

        dfs(0, numbers, target, arr);

        return answer;
    }

}
