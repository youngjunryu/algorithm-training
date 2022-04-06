package PROGRAMMERS;

import java.util.HashSet;

public class 소수_찾기_2 {
    boolean[] visited;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, numbers, "");
        }

        return set.size();
    }

    private void dfs(int curDepth, int depth, String numbers, String temp) {
        if (curDepth == depth && isPrime(temp)) {
            set.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            temp += numbers.charAt(i);
            dfs(curDepth + 1, depth, numbers, temp);
            visited[i] = false;
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    private boolean isPrime(String temp) {
        int num = Integer.parseInt(temp);
        if (num == 0 || num == 1) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
