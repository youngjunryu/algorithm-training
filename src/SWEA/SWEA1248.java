package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1248 {
    static int V;
    static int[][] parent;
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] deep;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            parent = new int[V+1][20];
            parent[1][0] = 1;
            deep = new int[V+1];
            visited = new boolean[V+1];
            adjList = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList.get(s).add(e);
            }

            dfs(1, 0);
            connecting();

            int result = LCA(p1, p2);
            int count = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(result);

            while(!q.isEmpty()) {
                int n = q.poll();
                count += adjList.get(n).size();
                for(int next : adjList.get(n)) {
                    q.offer(next);
                }
            }

            System.out.println("#" + tc + " " + result + " " + count);
        }
    }

    private static void dfs(int current, int depth) {
        visited[current] = true;
        deep[current] = depth;

        for(int next : adjList.get(current)) {
            if(visited[next])
                continue;
            parent[next][0] = current;
            dfs(next, depth + 1);
        }
    }

    private static void connecting() {
        for(int p = 1; p < 20; p++) {
            for(int cur = 1; cur <= V; cur++) {
                parent[cur][p] = parent[parent[cur][p-1]][p-1];
            }
        }
    }

    private static int LCA(int p1, int p2) {
        if(deep[p1] > deep[p2]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }

        for(int i = 19; i >= 0; i--) {
            int jump = 1 << i;
            if(deep[p2] - deep[p1] >= jump)
                p2 = parent[p2][i];
        }

        if(p1 == p2)
            return p1;

        for(int i = 19; i >= 0; i--) {
            if(parent[p1][i] == parent[p2][i]) continue;

            p1 = parent[p1][i];
            p2 = parent[p2][i];
        }

        return parent[p1][0];
    }
}