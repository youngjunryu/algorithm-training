package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9372 {
    static List<List<Integer>> airplane;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            answer = 0;
            airplane = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n; i++) {
                airplane.add(new LinkedList<>());
            }
            visited = new boolean[n+1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                airplane.get(a).add(b);
                airplane.get(b).add(a);
            }

            visited[1] = true;
            dfs(1);

            System.out.println(answer);
        }
    }

    private static void dfs(int cur) {
        for (int next : airplane.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                answer++;
                dfs(next);
            }
        }
    }
}
