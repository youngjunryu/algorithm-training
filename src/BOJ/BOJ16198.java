package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16198 {
    static int power = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> g = new LinkedList<>();
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            g.add(Integer.parseInt(st.nextToken()));
        }

        dfs(N, g, sum);

        System.out.println(power);
    }

    private static void dfs(int n, List<Integer> g, int sum) {
        if (n == 2) {
            power = Math.max(sum, power);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            int weight = g.get(i-1) * g.get(i+1);
            int removeValue = g.remove(i);
            dfs(n-1, g, sum + weight);
            g.add(i, removeValue);
        }
    }
}
