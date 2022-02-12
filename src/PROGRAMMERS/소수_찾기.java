package PROGRAMMERS;

import java.util.*;

public class 소수_찾기 {
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    String temp;

    private boolean isPrime(int n) {
        if(n == 0) return false;
        if(n == 1) return false;
        for(int i = 2; i < n; i++)
            if(n % i == 0) return false;
        return true;
    }

    private void dfs(int level, int length, String numbers) {
        if (level == length) {
            set.add(Integer.parseInt(temp));
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp += numbers.charAt(i);
                dfs(level + 1, length, numbers);
                temp = temp.substring(0, temp.length() - 1);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        temp = "";
        int cnt = 0;

        for(int i = 1; i <= numbers.length(); i++)
            dfs(0, i, numbers);

        for(int i : set)
            if(isPrime(i)) cnt++;

        return cnt;
    }
}
